package com.markcus.spring.resource;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.markcus.spring.dto.UserDto;
import com.markcus.spring.dto.response.collection.DtoCollectionResponse;
import com.markcus.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = {"/api/users"})
@Slf4j
@RequiredArgsConstructor
public class UserResource {
	
	private final UserService userService;
	
	@GetMapping
	public ResponseEntity<DtoCollectionResponse<UserDto>> findAll() {
		log.info("*** UserDto List, controller; fetch all platform users *");
		return ResponseEntity.ok(DtoCollectionResponse.<UserDto>builder().collection(this.userService.findAll()).build());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> findById(
			@PathVariable("userId")
			@NotBlank(message = "Platform user ID cannot be blank")
			@Valid final String platformUserId) {
		log.info("*** UserDto, controller; fetch platform user by ID *");
		return ResponseEntity.ok(this.userService.findById(Integer.parseInt(platformUserId.strip())));
	}
	
	@PostMapping
	public ResponseEntity<UserDto> save(
			@RequestBody 
			@NotNull(message = "Platform user data cannot be null")
			@Valid final UserDto platformUserDto) {
		log.info("*** UserDto, controller; create new platform user *");
		return ResponseEntity.ok(this.userService.save(platformUserDto));
	}
	
	@PutMapping
	public ResponseEntity<UserDto> update(
			@RequestBody 
			@NotNull(message = "Platform user data cannot be null") 
			@Valid final UserDto platformUserDto) {
		log.info("*** UserDto, controller; update platform user *");
		return ResponseEntity.ok(this.userService.update(platformUserDto));
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> update(
			@PathVariable("userId") 
			@NotBlank(message = "Input must not blank") final String userId, 
			@RequestBody 
			@NotNull(message = "Input must not NULL") 
			@Valid final UserDto userDto) {
		log.info("*** UserDto, resource; update user with userId *");
		return ResponseEntity.ok(this.userService.update(Integer.parseInt(userId.strip()), userDto));
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Boolean> deleteById(@PathVariable("userId") @NotBlank(message = "Input must not blank") @Valid final String userId) {
		log.info("*** Boolean, resource; delete user by id *");
		this.userService.deleteById(Integer.parseInt(userId));
		return ResponseEntity.ok(true);
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<UserDto> findByUsername(
			@PathVariable("username") 
			@NotBlank(message = "Input must not blank") 
			@Valid final String username) {
		return ResponseEntity.ok(this.userService.findByUsername(username));
	}
	
	
	
}










