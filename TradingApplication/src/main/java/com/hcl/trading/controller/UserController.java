package com.hcl.trading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trading.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

}
