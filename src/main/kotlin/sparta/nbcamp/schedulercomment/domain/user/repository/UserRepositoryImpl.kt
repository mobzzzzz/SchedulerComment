package sparta.nbcamp.schedulercomment.domain.user.repository

import org.springframework.stereotype.Repository
import sparta.nbcamp.schedulercomment.domain.user.model.QUser
import sparta.nbcamp.schedulercomment.infra.querydsl.QueryDslSupport

@Repository
class UserRepositoryImpl : CustomUserRepository, QueryDslSupport() {

    private val user = QUser.user

    override fun updateNickname(userId: Long, nickname: String) {
        queryFactory.update(user)
            .set(user.nickname, nickname)
            .where(user.id.eq(userId))
            .execute()
    }
}