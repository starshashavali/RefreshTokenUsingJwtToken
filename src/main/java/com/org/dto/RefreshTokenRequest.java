package com.org.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenRequest {

	@NotBlank(message = "Token cannot be blank")
	@Size(min = 5, max = 50, message = "Token must be between 10 and 50 characters")
	private String token;
}
