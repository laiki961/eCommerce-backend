package com.ventail.ecommerce.api;

import com.google.firebase.auth.FirebaseToken;
import com.ventail.ecommerce.domain.dto.response.UserInfoResponseDto;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserApi {
    @GetMapping("/info/me")
    public UserInfoResponseDto getMyUserInfo(Principal principal){
        FirebaseToken firebaseToken = getFirebaseTokenFromPrincipal(principal);
        UserInfoResponseDto dto = new UserInfoResponseDto();
        dto.setUid(firebaseToken.getUid());
        dto.setName(firebaseToken.getName());
        return dto;
    }

    private FirebaseToken getFirebaseTokenFromPrincipal(Principal principal){
        if(principal instanceof PreAuthenticatedAuthenticationToken){
            PreAuthenticatedAuthenticationToken preAuthenticated = (PreAuthenticatedAuthenticationToken) principal; //typecasting // polymorphism
            return (FirebaseToken) preAuthenticated.getPrincipal();
        }
        return  null;
    }


}
