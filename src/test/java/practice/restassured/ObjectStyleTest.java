package practice.restassured;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.Test;
import practice.restassured.controllers.PetController;
import practice.restassured.models.PetModel;

public class ObjectStyleTest {
    @Test
    public void testAddNewPetToPetStore() {
        int idTestValue = RandomUtils.nextInt(0, 9000);
        String testPetName = RandomStringUtils.randomNumeric(5);
        PetModel testPet = new PetModel(idTestValue, null, testPetName, null, null, "AVALUABLE");

        PetModel pet = new PetController().addNewPet(testPet);
        System.out.println(pet);
    }

}
