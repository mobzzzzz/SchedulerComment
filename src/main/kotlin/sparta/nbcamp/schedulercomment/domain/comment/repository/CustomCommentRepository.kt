package sparta.nbcamp.schedulercomment.domain.comment.repository

import java.time.LocalDateTime

interface CustomCommentRepository {
    fun updateUserNicknames()
    fun deleteOldSoftDeletedComments(expireDate: LocalDateTime)
}
