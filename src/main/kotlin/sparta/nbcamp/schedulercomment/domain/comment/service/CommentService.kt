package sparta.nbcamp.schedulercomment.domain.comment.service

import org.springframework.stereotype.Service
import sparta.nbcamp.schedulercomment.domain.comment.repository.CommentRepository
import java.time.Instant
import java.time.temporal.ChronoUnit

@Service
class CommentService(
    val commentRepository: CommentRepository
) {

    fun updateNicknames() {
        println("updateNicknames()")
        commentRepository.updateUserNicknames()
    }

    fun deleteOldSoftDeletedComments() {
        println("deleteOldSoftDeletedComments()")
        val expireTimestamp = Instant.now().minus(30, ChronoUnit.DAYS).toEpochMilli()
        commentRepository.deleteOldSoftDeletedComments(expireTimestamp)
    }
}
