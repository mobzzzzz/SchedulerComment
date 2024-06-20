package sparta.nbcamp.schedulercomment.domain.user.repository

import org.springframework.data.jpa.repository.JpaRepository
import sparta.nbcamp.schedulercomment.domain.user.model.User

interface UserRepository : JpaRepository<User, Long>, CustomUserRepository