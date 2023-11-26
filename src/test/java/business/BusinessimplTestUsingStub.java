package business;

import data.dataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class SomeDataServicestub implements dataService {
    @Override
    public int[] retriveAllData() {
        return new int[]{1,2,3,4};
    }
}

class SomeDataServicestubEmptyArray implements dataService {
    @Override
    public int[] retriveAllData() {
        return new int[]{};
    }
}

class SomeDataServicestubOneValue implements dataService {
    @Override
    public int[] retriveAllData() {
        return new int[]{1};
    }
}

class someDataServiceStubBasic implements dataService{

    @Override
    public int[] retriveAllData() {
        return new int[]{1,2,3,4,5};
    }
}

class BusinessimplTestUsingStub {

    @Test
    void calculateSum_basic_using_data_service() {
        Businessimpl business =new Businessimpl();
        business.setSomedataservice(new someDataServiceStubBasic());
        int actualResult=business.calculateSum_usingDataService();
        int expectedResult=15;
        assertEquals(expectedResult,actualResult);
    }


    @Test
    void calculateSum_emptyArray_using_data_service(){
        Businessimpl business =new Businessimpl();
        business.setSomedataservice(new SomeDataServicestubEmptyArray());
        int actualResult=business.calculateSum_usingDataService();
        int expectedResult=0;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void calculateSum_oneValue_using_data_service(){
        Businessimpl business =new Businessimpl();
        business.setSomedataservice(new SomeDataServicestubOneValue());
        int actualResult=business.calculateSum_usingDataService();
        int expectedResult=1;
        assertEquals(expectedResult,actualResult);
    }


    @Test
    void calculateSum_usingDataService(){
        Businessimpl business =new Businessimpl();
        business.setSomedataservice(new SomeDataServicestub());
        int actualResult=business.calculateSum_usingDataService();
        assertEquals(10,actualResult);
    }





}