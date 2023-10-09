package com.org.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
	
	   @NotBlank(message = "Name cannot be blank")
	    private String name;

	    @NotBlank(message = "Password cannot be blank")
	    @Size(min = 3, max = 20, message = "Password must be between 6 and 20 characters")
	    private String password;
}
