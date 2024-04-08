package ra.prjmd2.presentation;

import ra.prjmd2.utils.InputMethods;

public class MenuAdmin {
    private static MenuAdmin menuAdmin = new MenuAdmin();
    // Singleton
    public static MenuAdmin getInstance(){
        return menuAdmin;
    }
    private MenuAdmin(){

    }
    public void displayMenuAdmin(){
        System.out.println("chao mung toi trang quan tri");
        InputMethods.pressAnyKey();
    }
}
