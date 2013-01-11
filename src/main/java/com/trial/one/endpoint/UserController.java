package com.trial.one.endpoint;

import com.trial.one.domain.User;
import com.trial.one.proxy.IUserService;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Arun
 * Date: 8/1/13
 * Time: 4:25 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private Mapper mapper;

    @Autowired
    private IUserService userService;


   /* @RequestMapping(value = "/user/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) throws PowerWifiException {



        checkNotNull(userDTO, new PowerWifiException("Null User"));


        User user = mapper.map(userDTO, User.class);

        user = userService.register(user);
        userDTO = mapper.map(user,UserDTO.class);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);





    }

    @ExceptionHandler(PowerWifiException.class)
    @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
    @ResponseBody
    public ResponseEntity<PowerWifiException> handlePowerWifiException(PowerWifiException ex)
    {
        return new ResponseEntity<PowerWifiException>(ex, HttpStatus.EXPECTATION_FAILED);
    }
*/


    /* @RequestMapping(value = "/user/me", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDTO> me(){
        return null;
    }*/

    @RequestMapping(value = "/user/me", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    public ResponseEntity<User> whoAmI(Authentication authentication,Principal principal)
    {


        User user = userService.findByEmail(principal.getName());


        return new ResponseEntity<User>(user, HttpStatus.OK);


    }




   /* @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping(value = "/user", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDTO> update(Principal principal,@RequestBody UserDTO userDTO) throws  PowerWifiException
    {

        User exUser = userService.findByEmail(principal.getName());

        checkNotNull(userDTO, new PowerWifiException("Null User"));
        checkNotNull(exUser, new PowerWifiException("Username Does Not Exist"));

        exUser.setLastName(userDTO.getLastName());
        exUser.setFirstName(userDTO.getFirstName());

        User user = userService.updateProfile(exUser);

        userDTO = mapper.map(user,UserDTO.class);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);


    }*/


    /*@PreAuthorize("hasAnyRole('USER')")
    @RequestMapping(value = "/user/password", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDTO> updatePassword(Principal principal,@RequestBody UserDTO userDTO)  throws PowerWifiException
    {
        User exUser = userService.findByEmail(principal.getName());

        checkNotNull(userDTO, new PowerWifiException("Null User"));
        checkNotNull(exUser, new PowerWifiException("Username Does Not Exist"));
        exUser.setPassword(userDTO.getPassword());

        User user = userService.updatePassword(exUser);

        userDTO = mapper.map(user,UserDTO.class);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);




    }*/


}
