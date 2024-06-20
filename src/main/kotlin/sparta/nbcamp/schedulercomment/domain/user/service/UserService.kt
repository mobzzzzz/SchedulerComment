package sparta.nbcamp.schedulercomment.domain.user.service

import org.springframework.stereotype.Service
import sparta.nbcamp.schedulercomment.domain.user.dto.UpdateNicknameRequest
import sparta.nbcamp.schedulercomment.domain.user.repository.UserRepository

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun updateNickname(userId: Long, request: UpdateNicknameRequest) {
        userRepository.updateNickname(userId, request.nickname)
    }

    fun deleteUser(userId: Long) {
        userRepository.deleteById(userId)
    }
}