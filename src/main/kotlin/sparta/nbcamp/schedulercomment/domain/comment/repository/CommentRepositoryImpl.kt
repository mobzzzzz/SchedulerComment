package sparta.nbcamp.schedulercomment.domain.comment.repository

import org.springframework.stereotype.Repository
import sparta.nbcamp.schedulercomment.infra.querydsl.QueryDslSupport

@Repository
class CommentRepositoryImpl : CustomCommentRepository, QueryDslSupport()