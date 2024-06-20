package sparta.nbcamp.schedulercomment.domain.user.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import sparta.nbcamp.schedulercomment.domain.common.BaseTimeEntity

@Entity
@Table(name = "app_user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val username: String,

    val password: String,

    val nickname: String,
) : BaseTimeEntity()