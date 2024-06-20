package sparta.nbcamp.schedulercomment.domain.comment.service

import org.springframework.stereotype.Service
import sparta.nbcamp.schedulercomment.domain.comment.repository.CommentRepository
import java.time.LocalDateTime

@Service
class CommentService(
    val commentRepository: CommentRepository
) {

    fun updateNicknames() {
        commentRepository.updateUserNicknames()
    }

    fun deleteOldSoftDeletedComments() {
        val expireDate = LocalDateTime.now().minusSeconds(30)
        commentRepository.deleteOldSoftDeletedComments(expireDate)
    }
}
