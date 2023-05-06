package noteappp.controller;

import lombok.RequiredArgsConstructor;
import noteappp.dto.UserDTO;
import noteappp.entity.AuthenticationRequest;
import noteappp.entity.User;
import noteappp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

//    @GetMapping("/ifUserExists/{id}")
//    public ResponseEntity<User> findById(@PathVariable String id) throws InterruptedException {
//        Thread.sleep(5000);
//        return ResponseEntity.ok(userService.findById(id));
//    }

    @GetMapping("/user/auth")
    public ResponseEntity<User> auth(@PathVariable String id) throws InterruptedException {
        Thread.sleep(5000);
        User user = userService.findById(id);

    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }


    @PutMapping
    public ResponseEntity<User> update(@RequestParam String id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateById(id, user));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        userService.deleteById(id);
    }

}