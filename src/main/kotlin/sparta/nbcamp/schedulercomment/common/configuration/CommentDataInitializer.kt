package sparta.nbcamp.schedulercomment.common.configuration

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sparta.nbcamp.schedulercomment.domain.comment.model.Comment
import sparta.nbcamp.schedulercomment.domain.comment.repository.CommentRepository
import sparta.nbcamp.schedulercomment.domain.user.model.User
import sparta.nbcamp.schedulercomment.domain.user.repository.UserRepository

@Configuration
class CommentDataInitializer(
    private val commentRepository: CommentRepository,
    private val userRepository: UserRepository
) {
    @Bean
    fun run() = ApplicationRunner {
        val user = User(
            username = "testuser",
            password = "password123",
            nickname = "TestUser",
        )

        userRepository.save(user)

        val comments = (1..10).map {
            Comment(
                content = "comment $it",
                nickname = user.nickname,
                userId = user.id
            )
        }

        commentRepository.saveAll(comments)
    }
}