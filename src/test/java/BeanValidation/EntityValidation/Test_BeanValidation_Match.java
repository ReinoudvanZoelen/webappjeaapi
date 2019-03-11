package BeanValidation.EntityValidation;

import BeanValidation.BeanValidation_ValidationService;
import Entities.Match;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test_BeanValidation_Match {

    private String message_SittingTableNumber = "Please enter a valid tablenumber for your match. Table numbers start at 1.";

    @Test
    public void Test_SittingTableNumber_Positive(){
        Match m = new Match();
        m.setSittingTableNumber(1);

        ArrayList<String> validationMessages = BeanValidation_ValidationService.ValidateBeans(m);

        assertFalse(validationMessages.contains(this.message_SittingTableNumber));
    }

    @Test
    public void Test_SittingTableNumber_Zero(){
        Match m = new Match();
        m.setSittingTableNumber(0);

        ArrayList<String> validationMessages = BeanValidation_ValidationService.ValidateBeans(m);

        assertTrue(validationMessages.contains(this.message_SittingTableNumber));
    }

    @Test
    public void Test_SittingTableNumber_Negative(){
        Match m = new Match();
        m.setSittingTableNumber(-1);

        ArrayList<String> validationMessages = BeanValidation_ValidationService.ValidateBeans(m);

        assertTrue(validationMessages.contains(this.message_SittingTableNumber));
    }

    private String message_TeamScores = "Please enter valid teamscores for your match. Teamscores must be a list with exactly two of TeamScore.";

    @Test
    public void Test_TeamScores_EnterBoth(){

    }
    @Test
    public void Test_TeamScores_EnterSingle(){

    }
    @Test
    public void Test_TeamScores_EnterNone(){

    }
    @Test
    public void Test_TeamScores_EnterBothNull(){

    }
    @Test
    public void Test_TeamScores_EnterSingleNull(){

    }
}
