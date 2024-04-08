package ra.prjmd2.presentation;

import ra.prjmd2.business.design.IAuthication;
import ra.prjmd2.business.designimpl.AuthenticationService;
import ra.prjmd2.business.entity.RoleName;
import ra.prjmd2.business.entity.User;
import ra.prjmd2.utils.InputMethods;

public class Main {
    private static MenuUser menuUser = new MenuUser();
    private static IAuthication authication = new AuthenticationService();
    public static User user = null;
    public static void main(String[] args) {
        while (true){
            System.out.println("++++++++++++++++++++++++MENU+++++++++++++++++++++++");
            System.out.println("1. Dang nhap");
            System.out.println("2. Dang ky");
            System.out.println("3. Thoat");
            System.out.println("Nhap chuc nang");
            byte choice = InputMethods.getByte();
            switch (choice){
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Thoat");
                default:
                    System.err.println("Lua chon khong hop le");
            }
            if (choice==3){
                break;
            }
        }
    }
    public static void login(){
        System.out.println("----------Dang nhap--------------");
        System.out.println("Nhap username :");
        String username  = InputMethods.getString();
        System.out.println("Nhap password :");
        String password  = InputMethods.getString();

        User userLogin =  authication.login(username,password);
        if (userLogin==null){
            System.err.println("Tai khoan hoac mat khau khong chinh xac");
            System.out.println("1. Tiep tuc dang nhap");
            System.out.println("2. Ban chua co tai khoan, Dang ky ngay");
            System.out.println("3. Thoat");
            System.out.println("------Nhap lua chon--------");
            byte choice = InputMethods.getByte();
            switch (choice){
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    return;
                default:
                    System.err.println("nhap lua chon ko chinh xac");
            }
        }else {
            if (userLogin.getRole().equals(RoleName.ROLE_ADMIN)){
                user = userLogin;
                MenuAdmin.getInstance().displayMenuAdmin();
            }else if (userLogin.getRole().equals(RoleName.ROLE_USER)){
                if (!userLogin.isStatus()){
                    System.err.println("Tai khoan da bi khoa, vui long lien he admin (09837465263)");
                }else {
                    user = userLogin;
                    menuUser.displayMenuUser();
                }
            }else {
                System.err.println("khong co quyen truy cap");
            }
        }
    }
    public static void register(){
        System.out.println("--------------Dang ky----------------");
        User user = new User();
        System.out.println("Nhap ten dang nhap");
        user.inputUsername();
        System.out.println("Nhap ten mat khau");
        user.inputPassword();
        System.out.println("Nhap ten email");
        user.inputEmail();
        System.out.println("Nhap ten phone");
        user.inputPhoneNumber();
        System.out.println("Nhap ten fullname");
        user.inputFullname();
        authication.register(user);
        System.out.println("Dang ki thanh cong");
        login();
    }
}
