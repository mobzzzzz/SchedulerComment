package sparta.nbcamp.schedulercomment.domain.user.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sparta.nbcamp.schedulercomment.domain.user.dto.UpdateNicknameRequest
import sparta.nbcamp.schedulercomment.domain.user.service.UserService

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    @PatchMapping("/{userId}")
    fun updateNickname(@PathVariable userId: Long, @RequestBody request: UpdateNicknameRequest): ResponseEntity<Unit> {
        userService.updateNickname(userId, request)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: Long): ResponseEntity<Unit> {
        userService.deleteUser(userId)
        return ResponseEntity.noContent().build()
    }
}