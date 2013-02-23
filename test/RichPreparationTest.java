import convertor.StringConvert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Iterator;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created with IntelliJ IDEA.
 * User: cherish
 * Date: 13-2-23
 * Time: 下午8:23
 * To change this template use File | Settings | File Templates.
 */
public class RichPreparationTest {
    @Test
    public void shouldFundsPreparedWhenInputRightNumber(){
        UserInput userInput = Mockito.mock(UserInput.class) ;
        Mockito.when(userInput.readUserInput()).thenReturn("15000");
        RichPreparation richPreparation=new RichPreparation(userInput);
        richPreparation.prepareInteractiveData();
        Mockito.verify(userInput, Mockito.times(0)).printMessage(Mockito.anyString());
        assertThat(richPreparation.getRichGame().getFunds(), is(15000)) ;
    }

    @Test
    public void shouldFundsPreparedRightUntilInputTheValidNumberAfterOneInvalidInput(){
        UserInput userInput = Mockito.mock(UserInput.class) ;
        Mockito.when(userInput.readUserInput()).thenReturn("s105000").thenReturn("10000");
        RichPreparation richPreparation=new RichPreparation(userInput);
        richPreparation.prepareInteractiveData();
        Mockito.verify(userInput, Mockito.times(1)).printMessage(StringConvert.FUNDS_SHOULD_BE_A_NUMBER);
        assertThat(richPreparation.getRichGame().getFunds(), is(10000)) ;
    }

    @Test
    public void shouldFundsPreparedRightUntilInputTheValidNumberAfterThreeInvalidInput(){
        UserInput userInput = Mockito.mock(UserInput.class) ;
        Mockito.when(userInput.readUserInput()).thenReturn("105000").thenReturn("10df000").thenReturn("900").thenReturn("1000");
        RichPreparation richPreparation=new RichPreparation(userInput);
        richPreparation.prepareInteractiveData();
        Mockito.verify(userInput, Mockito.times(1)).printMessage(StringConvert.Funds_SHOULD_NOT_EXCEED_THE_MAXIMUM);
        Mockito.verify(userInput, Mockito.times(1)).printMessage(StringConvert.FUNDS_SHOULD_BE_A_NUMBER);
        Mockito.verify(userInput, Mockito.times(1)).printMessage(StringConvert.FUNDS_SHOULD_NOT_UNDER_THE_MINIMUM);
        assertThat(richPreparation.getRichGame().getFunds(), is(1000)) ;
    }




}
