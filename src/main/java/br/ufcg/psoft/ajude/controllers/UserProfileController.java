package br.ufcg.psoft.ajude.controllers;

import br.ufcg.psoft.ajude.business.UserProfileBusinessDelegate;
import br.ufcg.psoft.ajude.dto.UserProfileDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Controller do perfil do usuário")
@RestController
@RequestMapping("/v1/profile")
public class UserProfileController {

    @Autowired
    private UserProfileBusinessDelegate userProfileBusinessDelegate;

    @CrossOrigin
    @ApiOperation(value = "Busca o perfil de um usuário cadastrado")
    @GetMapping("/{email}")
    public ResponseEntity<UserProfileDTO> getUserProfile(@PathVariable String email){
        return new ResponseEntity<UserProfileDTO>(this.userProfileBusinessDelegate.getProfile(email), HttpStatus.OK);
    }
}
