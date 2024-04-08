package ra.prjmd2.presentation;

import org.mindrot.jbcrypt.BCrypt;
import ra.prjmd2.business.entity.RoleName;
import ra.prjmd2.business.entity.User;
import ra.prjmd2.utils.IOFile;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<User> users = IOFile.readFromFile(IOFile.USER_PATH);
        User admin = new User();
        admin.setId(1);
        admin.setUsername("admin123");
        admin.setPassword(BCrypt.hashpw("admin123",BCrypt.gensalt(5)));
        admin.setRole(RoleName.ROLE_ADMIN);
        users.add(admin);
        IOFile.writeToFile(IOFile.USER_PATH,users);
    }
}
