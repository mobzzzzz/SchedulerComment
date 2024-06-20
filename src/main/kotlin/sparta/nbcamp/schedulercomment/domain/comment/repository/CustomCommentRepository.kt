package sparta.nbcamp.schedulercomment.domain.comment.repository

interface CustomCommentRepository {
    fun updateUserNicknames()
    fun deleteOldSoftDeletedComments(expireTimestamp: Long)
}
