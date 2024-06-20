package sparta.nbcamp.schedulercomment.domain.comment.repository

import com.querydsl.jpa.JPAExpressions
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import sparta.nbcamp.schedulercomment.domain.comment.model.QComment
import sparta.nbcamp.schedulercomment.domain.user.model.QUser
import sparta.nbcamp.schedulercomment.infra.querydsl.QueryDslSupport
import java.time.LocalDateTime

@Repository
class CommentRepositoryImpl : CustomCommentRepository, QueryDslSupport() {

    private val comment = QComment.comment
    private val user = QUser.user

    @Transactional
    override fun updateUserNicknames() {
        queryFactory.update(comment)
            .set(
                comment.nickname,
                JPAExpressions.select(user.nickname)
                    .from(user)
                    .where(user.id.eq(comment.userId))
            )
            .where(
                JPAExpressions.selectOne()
                    .from(user)
                    .where(user.id.eq(comment.userId))
                    .exists()
            )
            .execute()
    }

    @Transactional
    override fun deleteOldSoftDeletedComments(expireDate: LocalDateTime) {
        // @SQLRestriction 제약때문에 native query로 처리
        entityManager.createNativeQuery(
            "DELETE FROM comment WHERE status = 'DELETED' AND deleted_at < :expireDate"
        )
            .setParameter("expireDate", expireDate)
            .executeUpdate()
    }
}