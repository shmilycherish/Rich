package Game;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-23
 * Time: 下午7:34
 * To change this template use File | Settings | File Templates.
 */
public class UserInput {
    private Scanner scanner=new Scanner(System.in);
    public String readUserInput() {
        return    scanner.nextLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
