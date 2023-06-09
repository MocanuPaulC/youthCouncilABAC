package be.kdg.youthcouncil.service.userService;

import be.kdg.youthcouncil.controllers.mvc.viewModels.UserRegisterViewModel;
import be.kdg.youthcouncil.domain.user.User;

import java.util.List;
import java.util.Map;

public interface UserService {
	List<User> findAllUsers();

	void create(UserRegisterViewModel userViewModel);

	User findById(long id);

	public void processOAuthPostLogin(String username, Map<String, Object> attributes, String clientName);

	void save(UserRegisterViewModel userViewModel);

	boolean updateRole(long id, String role);

	void updateUsername(String oldUsername, String newUsername);
	
	void save(User user);

	User findByUsername(String username);

	List<User> findAllWithIdeas();

	boolean exists(String username);
}
