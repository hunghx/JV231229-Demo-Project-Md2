package ra.prjmd2.business.design;

import ra.prjmd2.business.entity.User;

public interface IAuthication {
    User login(String username,String password);
    void register(User user);
}
