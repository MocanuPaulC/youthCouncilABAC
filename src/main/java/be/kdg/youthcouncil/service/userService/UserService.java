package be.kdg.youthcouncil.service.userService;

import be.kdg.youthcouncil.controllers.mvc.viewModels.UserRegisterViewModel;
import be.kdg.youthcouncil.domain.user.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(UserRegisterViewModel userViewModel);

    User findUserByUsername(String username);
}