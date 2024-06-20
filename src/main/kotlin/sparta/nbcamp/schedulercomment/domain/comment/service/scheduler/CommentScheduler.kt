package sparta.nbcamp.schedulercomment.domain.comment.service.scheduler

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import sparta.nbcamp.schedulercomment.domain.comment.repository.CommentRepository
import java.time.Instant
import java.time.temporal.ChronoUnit

@Component
class CommentScheduler(
    private val commentRepository: CommentRepository
) {
    /* cron
    1 2 3 4 5 6  // 순서
    * * * * * *  // 실행주기 문자열

    // 순서별 정리
    1. 초(0-59)
    2. 분(0-59)
    3. 시간(0-23)
    4. 일(1-31)
    5. 월(1-12)
    6. 요일(0-7)
     */

    @Scheduled(cron = "0 0 6 * * *")
    fun updateNicknames() {
        commentRepository.updateUserNicknames()
    }

    @Scheduled(cron = "0 0 6 * * *")
    fun deleteOldSoftDeletedComments() {
        val expireTimestamp = Instant.now().minus(30, ChronoUnit.DAYS).toEpochMilli()
        commentRepository.deleteOldSoftDeletedComments(expireTimestamp)
    }
}