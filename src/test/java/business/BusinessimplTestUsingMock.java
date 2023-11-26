package business;

import data.dataService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BusinessimplTestUsingMock {

    @Test
    void calculateSum_basic_using_data_service() {
        Businessimpl business=new Businessimpl();
        dataService dataServiceMock=mock(dataService.class);
        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{1,2,3,4});
        business.setSomedataservice(dataServiceMock);
        int actualResult=business.calculateSum_usingDataService();
        int expected=10;
        assertEquals(expected,actualResult);
    }


    @Test
    void calculateSum_emptyArray_using_data_service(){
        Businessimpl business =new Businessimpl();
        dataService someDataServiceMock=mock(dataService.class);
        when(someDataServiceMock.retriveAllData()).thenReturn(new int[]{});
        business.setSomedataservice(someDataServiceMock);
        int actualResult=business.calculateSum_usingDataService();
        int expectedResult=0;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void calculateSum_oneValue_using_data_service(){
        Businessimpl business =new Businessimpl();
        dataService someDataServiceMock=mock(dataService.class);
        when(someDataServiceMock.retriveAllData()).thenReturn(new int[]{1});
        business.setSomedataservice(someDataServiceMock);
        int actualResult=business.calculateSum_usingDataService();
        int expectedResult=1;
        assertEquals(expectedResult,actualResult);
    }


    @Test
    void calculateSum_usingDataService(){
        Businessimpl business =new Businessimpl();
        dataService someDataServiceMock=mock(dataService.class);
        when(someDataServiceMock.retriveAllData()).thenReturn(new int[]{1,2,3,4});
        business.setSomedataservice(new SomeDataServicestub());
        int actualResult=business.calculateSum_usingDataService();
        assertEquals(10,actualResult);
    }





}