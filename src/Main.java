import auth.logs.LogsList;
import auth.uiForms.App;
import auth.user.UsersList;

public class Main {

    public static void main(String[] args) {
        UsersList.loadUsers();
        LogsList.loadLogs();

        //UI INTERFACE
        boolean menuIsOpen = true;
        App app = new App();
        app.setVisible(true);

        //CONSOLE INTERFACE
//        while (menuIsOpen) {
//            Scanner scanner = new Scanner(System.in);
//
//            if (!AuthData.getIsAuth()) {
//                System.out.println("1 - Signup\n2 - Sign in\n3 - logs\n0 - exit");
//                switch (scanner.nextLine()) {
//                    case "1":
//                        Registration.signup();
//                        break;
//                    case "2":
//                        SignIn.signIn();
//                        break;
//                    case "3":
//                        LogsList.showLogs();
//                        break;
//                    case "4":
//                        break;
//
//                    case "0":
//                        menuIsOpen = false;
//                        break;
//                    default:
//                        System.out.println("Enter correct value");
//                        break;
//                }
//            } else {
//                System.out.println("Hello " + AuthData.getUser().getUsername());
//                System.out.println("1 - logout\n2 - Get my info\n3 - logs\n0 - exit");
//                switch (scanner.nextLine()) {
//                    case "1":
//                        AuthData.logout();
//                        break;
//                    case "2":
//                        System.out.println(AuthData.getUser().toString());
//                        break;
//                    case "3":
//                        LogsList.showLogs();
//                        break;
//                    case "0":
//                        menuIsOpen = false;
//                        break;
//                    default:
//                        System.out.println("Enter correct value");
//                        break;
//                }
//            }
//
//        }
//        UsersList.saveUsersFile();
//        LogsList.saveLogsFile();

    }
}
