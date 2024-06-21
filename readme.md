# 댓글 스케줄러

## updateNicknames

10분마다 실행되는 작업으로 댓글에 기록된 user_id를 기반으로 댓글의 nickname 업데이트합니다.  
JPA 연관이 되어있지 않아 사용자가 탈퇴하더라도 댓글의 nickname은 마지막 상태로 유지됩니다.

```kotlin
@Scheduled(cron = "0 0/10 * * * *")
fun updateNicknames() {
    commentService.updateNicknames()
}
```

## deleteOldSoftDeletedComments

매일 오전 9시에 실행되는 작업으로 Soft delete된 댓글 중 일정 기간이 지난 댓글을 삭제합니다.

```kotlin
@Scheduled(cron = "0 0 9 * * *")
fun deleteOldSoftDeletedComments() {
    commentService.deleteOldSoftDeletedComments()
}
```

