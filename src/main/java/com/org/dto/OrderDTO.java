package com.org.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OrderDTO {
	
	private Integer orderId;
	
	 @NotBlank(message = "Order name cannot be blank")
	    @Size(max = 3, message = "Order name must not exceed 3 characters")
	    private String orderName;

	    @NotBlank(message = "Address cannot be blank")
	    @Size(max = 3, message = "Address must not exceed 3 characters")
	    private String address;


}
