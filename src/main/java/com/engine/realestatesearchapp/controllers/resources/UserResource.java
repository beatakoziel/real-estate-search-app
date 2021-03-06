package com.engine.realestatesearchapp.controllers.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String roleName;
}
