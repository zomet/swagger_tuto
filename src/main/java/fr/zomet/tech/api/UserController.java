package fr.zomet.tech.api;

import fr.zomet.tech.dtos.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1.0/users")
@Api(value = "UserController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, authorizations = {@Authorization("basicAuth")})
public class UserController {

    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "/{userId}", response = User.class)
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = User.class),
                    @ApiResponse(code = 204, message = "No content"),
                    @ApiResponse(code = 401, message = "Unauthorized")})
    public User getUserById(@PathVariable("userId") Long userId) {
        return User.create();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    public ResponseEntity<String> addUser(@RequestBody User user) {
        return ResponseEntity.ok("OK");
    }
}
