package com.jobseeker.technicaltest.controller;

import com.jobseeker.technicaltest.domain.dto.candidate.CandidateDto;
import com.jobseeker.technicaltest.domain.dto.response.ApiResponse;
import com.jobseeker.technicaltest.domain.dto.user.RegisterUserDto;
import com.jobseeker.technicaltest.domain.dto.user.UserDto;
import com.jobseeker.technicaltest.domain.entity.Candidate;
import com.jobseeker.technicaltest.domain.entity.User;
import com.jobseeker.technicaltest.mapper.CandidateMapper;
import com.jobseeker.technicaltest.service.AuthService;
import com.jobseeker.technicaltest.service.CandidateService;
import com.jobseeker.technicaltest.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthService authenticationService;
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private CandidateMapper candidateMapper;

    @PostMapping("/signup")
    public ApiResponse<Candidate> register(@RequestBody @Valid RegisterUserDto registerUserDto) {

        User newUser = authenticationService.signup(registerUserDto);
        Candidate candidate = candidateMapper.RegisterDtoToCandidate(registerUserDto);
        candidate.setUser(newUser);
        candidateService.saveCandidate(candidate);

        return new ApiResponse<Candidate>(true, "Register Success", candidate);
    }

    @PostMapping("/login")
    public ApiResponse<String> authenticate(@RequestBody UserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);


        String jwtToken = jwtService.generateToken(  authenticatedUser);

        return new ApiResponse<String>(true, "Login success", jwtToken);
    }
}
