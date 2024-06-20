package sparta.nbcamp.schedulercomment.domain.comment.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.SQLRestriction
import sparta.nbcamp.schedulercomment.domain.common.BaseTimeEntity

@Entity
@Table(name = "comment")
@SQLDelete(sql = "UPDATE comment SET status = 'DELETED', deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("status = 'ACTIVE'")
class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var content: String,

    var nickname: String,

    var status: CommentStatus = CommentStatus.ACTIVE,

    var userId: Long? = null,

    var deletedAt: Long? = null,
) : BaseTimeEntity()