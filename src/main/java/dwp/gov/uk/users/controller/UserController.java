package dwp.gov.uk.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dwp.gov.uk.users.model.User;
import dwp.gov.uk.users.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;

	@RequestMapping(value = "/users/london", method = RequestMethod.GET)
	public List<User> getLondonUsers() {
		return userservice.getLondonUsers();

	}
}
