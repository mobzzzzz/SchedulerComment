package sparta.nbcamp.schedulercomment.domain.comment.repository

import org.springframework.data.jpa.repository.JpaRepository
import sparta.nbcamp.schedulercomment.domain.comment.model.Comment

interface CommentRepository : JpaRepository<Comment, Long>, CustomCommentRepository