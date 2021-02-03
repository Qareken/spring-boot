package qr.market.backenf.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qr.market.backenf.domain.User;
import qr.market.backenf.security.SecurityUtils;
import qr.market.backenf.service.UserService;

@RestController
@RequestMapping("/api")
public class AccountResource {
    private final UserService userService;

    public AccountResource(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/account")
    public ResponseEntity<?>getAccount(){
        String login= SecurityUtils.getCurrentUserName().get();
        User user=userService.findByUser(login);
        System.out.println(login);
        return ResponseEntity.ok(user);
    }
}
