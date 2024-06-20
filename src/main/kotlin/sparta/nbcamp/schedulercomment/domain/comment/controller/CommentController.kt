package sparta.nbcamp.schedulercomment.domain.comment.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sparta.nbcamp.schedulercomment.domain.comment.service.CommentService

@RestController
@RequestMapping("/comments")
class CommentController(
    private val commentService: CommentService
) {
    @DeleteMapping("/{commentId}")
    fun deleteComment(@PathVariable commentId: Long): ResponseEntity<Unit> {
        commentService.deleteComment(commentId)
        return ResponseEntity.noContent().build()
    }
}