package sparta.nbcamp.schedulercomment.domain.comment.service.scheduler

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import sparta.nbcamp.schedulercomment.domain.comment.service.CommentService

@Component
class CommentScheduler(
    private val commentService: CommentService
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

    @Scheduled(cron = "0 0/1 * * * *")
    fun updateNicknames() {
        commentService.updateNicknames()
    }

    @Scheduled(cron = "0 0/1 * * * *")
    fun deleteOldSoftDeletedComments() {
        commentService.deleteOldSoftDeletedComments()
    }
}