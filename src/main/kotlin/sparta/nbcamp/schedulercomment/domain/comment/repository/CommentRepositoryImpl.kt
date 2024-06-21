package sparta.nbcamp.schedulercomment.domain.comment.repository

import com.querydsl.jpa.JPAExpressions
import org.springframework.stereotype.Repository
import sparta.nbcamp.schedulercomment.domain.comment.model.QComment
import sparta.nbcamp.schedulercomment.domain.user.model.QUser
import sparta.nbcamp.schedulercomment.infra.querydsl.QueryDslSupport

@Repository
class CommentRepositoryImpl : CustomCommentRepository, QueryDslSupport() {

    private val comment = QComment.comment
    private val user = QUser.user

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
}