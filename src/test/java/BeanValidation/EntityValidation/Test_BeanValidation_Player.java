package BeanValidation.EntityValidation;

import BeanValidation.BeanValidation_ValidationService;
import Entities.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Test_BeanValidation_Player {

    private String message_FullName = "Please enter a valid name for this player.";

    @Test
    public void Test_FullName_Entered(){
        Player p = new Player();
        p.setFullName("Reinoud van Zoelen");

        ArrayList<String> validationMessages = BeanValidation_ValidationService.ValidateBeans(p);

        assertFalse(validationMessages.contains(this.message_FullName));
    }

    @Test
    public void Test_FullName_Empty(){
        Player p = new Player();
        p.setFullName("");

        ArrayList<String> validationMessages = BeanValidation_ValidationService.ValidateBeans(p);

        assertTrue(validationMessages.contains(this.message_FullName));
    }

    @Test
    public void Test_FullName_Null(){
        Player p = new Player();
        p.setFullName(null);

        ArrayList<String> validationMessages = BeanValidation_ValidationService.ValidateBeans(p);

        assertTrue(validationMessages.contains(this.message_FullName));
    }
}
