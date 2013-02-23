import convertor.StringConvert;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-23
 * Time: 下午8:18
 * To change this template use File | Settings | File Templates.
 */
public class RichPreparation {
    public RichGame richGame=new RichGame();
    public void preparedFunds(Iterator<String> scanner) {
        String userInput=scanner.next();
        StringConvert stringConvert=new StringConvert();
        int funds=stringConvert.convertFunds(userInput);
        richGame.setFunds(funds);

    }
}
