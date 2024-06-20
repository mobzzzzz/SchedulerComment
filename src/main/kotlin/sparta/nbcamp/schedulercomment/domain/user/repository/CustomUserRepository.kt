package sparta.nbcamp.schedulercomment.domain.user.repository

interface CustomUserRepository {
    fun updateNickname(userId: Long, nickname: String)
}
