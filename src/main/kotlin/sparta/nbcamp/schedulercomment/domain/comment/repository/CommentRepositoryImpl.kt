package sparta.nbcamp.schedulercomment.domain.comment.repository

import com.querydsl.jpa.JPAExpressions
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import sparta.nbcamp.schedulercomment.domain.comment.model.CommentStatus
import sparta.nbcamp.schedulercomment.domain.comment.model.QComment
import sparta.nbcamp.schedulercomment.domain.user.model.QUser
import sparta.nbcamp.schedulercomment.infra.querydsl.QueryDslSupport

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
            .where(comment.status.eq(CommentStatus.ACTIVE))
            .execute()
    }

    @Transactional
    override fun deleteOldSoftDeletedComments(expireTimestamp: Long) {
        queryFactory.delete(comment)
            .where(
                comment.status.eq(CommentStatus.DELETED)
                    .and(comment.deletedAt.lt(expireTimestamp))
            )
            .execute()
    }
}