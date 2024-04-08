package ra.prjmd2.business.designimpl;

import org.mindrot.jbcrypt.BCrypt;
import ra.prjmd2.business.design.IAuthication;
import ra.prjmd2.business.entity.RoleName;
import ra.prjmd2.business.entity.User;
import ra.prjmd2.utils.IOFile;

import java.util.Comparator;
import java.util.List;

public class AuthenticationService implements IAuthication {
    private static List<User> userList ;
    static {
        userList = IOFile.readFromFile(IOFile.USER_PATH);
    }
    @Override
    public User login(String username, String password) {
        User userLogin  = getUserFromUsername(username);
        if (userLogin==null){
            return null;
        }
        boolean checkLogin = BCrypt.checkpw(password,userLogin.getPassword()); // kiem tra mat khau khop hay khong
        if (checkLogin){
            return userLogin;
        }
        return null;
    }

    @Override
    public void register(User user) {
        user.setId(getNewId());
        user.setRole(RoleName.ROLE_USER);
        user.setStatus(true);
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(5)));

        userList.add(user);
        IOFile.writeToFile(IOFile.USER_PATH,userList);
    }
    private User getUserFromUsername(String username){
        return userList.stream().filter(user->user.getUsername().equals(username)).findFirst().orElse(null);
    }
    private int getNewId(){
        int max = userList.stream().map(User::getId).max(Comparator.naturalOrder()).orElse(0);
        return max+1;
    }
}
