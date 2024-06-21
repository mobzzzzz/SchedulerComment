package sparta.nbcamp.schedulercomment.domain.comment.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import sparta.nbcamp.schedulercomment.domain.comment.repository.CommentRepository
import java.time.LocalDateTime

@Service
class CommentService(
    val commentRepository: CommentRepository
) {

    @Transactional
    fun updateNicknames() {
        commentRepository.updateUserNicknames()
    }

    @Transactional
    fun deleteOldSoftDeletedComments() {
        val expireDate = LocalDateTime.now().minusSeconds(30)
        commentRepository.deleteOldSoftDeletedComments(expireDate)
    }

    fun deleteComment(commentId: Long) {
        commentRepository.deleteById(commentId)
    }
}
