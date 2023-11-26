package business;

import data.dataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessimplTest {

    @Test
    void calculateSum_basic() {
        Businessimpl business =new Businessimpl();
        int actualResult=business.calculateSum(new int[]{1,2,3});
        int expectedResult=6;
        assertEquals(expectedResult,actualResult);
    }


    @Test
    void calculateSum_emptyArray(){
        Businessimpl business =new Businessimpl();
        int actualResult=business.calculateSum(new int[]{});
        int expectedResult=0;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void calculateSum_oneValue(){
        Businessimpl business =new Businessimpl();
        int actualResult=business.calculateSum(new int[]{1});
        int expectedResult=1;
        assertEquals(expectedResult,actualResult);
    }





}