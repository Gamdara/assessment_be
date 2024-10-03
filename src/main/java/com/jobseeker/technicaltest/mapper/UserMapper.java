package com.jobseeker.technicaltest.mapper;

import com.jobseeker.technicaltest.domain.dto.candidate.CandidateDto;
import com.jobseeker.technicaltest.domain.dto.user.RegisterUserDto;
import com.jobseeker.technicaltest.domain.dto.user.UserDto;
import com.jobseeker.technicaltest.domain.entity.Candidate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto RegisterDtoToUserDto(RegisterUserDto registerUserDto);
}
