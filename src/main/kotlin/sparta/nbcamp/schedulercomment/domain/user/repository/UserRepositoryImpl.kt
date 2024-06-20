package sparta.nbcamp.schedulercomment.domain.user.repository

import org.springframework.stereotype.Repository
import sparta.nbcamp.schedulercomment.infra.querydsl.QueryDslSupport

@Repository
class UserRepositoryImpl : CustomUserRepository, QueryDslSupport()