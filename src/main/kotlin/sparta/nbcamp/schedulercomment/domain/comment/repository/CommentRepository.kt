package sparta.nbcamp.schedulercomment.domain.comment.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import sparta.nbcamp.schedulercomment.domain.comment.model.Comment
import java.time.LocalDateTime

interface CommentRepository : JpaRepository<Comment, Long>, CustomCommentRepository {
    @Modifying
    @Query(value = "DELETE FROM comment WHERE status = 'DELETED' AND deleted_at < :expireDate", nativeQuery = true)
    fun deleteOldSoftDeletedComments(expireDate: LocalDateTime)
}