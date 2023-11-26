package business;

import data.dataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BusinessimplTestUsingMock {
    @InjectMocks
    Businessimpl business =new Businessimpl();
    @Mock
    dataService someDataServiceMock;



    @Test
    void calculateSum_basic_using_data_service() {
        when(someDataServiceMock.retriveAllData()).thenReturn(new int[]{1,2,3,4});
        int actualResult=business.calculateSum_usingDataService();
        int expected=10;
        assertEquals(expected,actualResult);
    }


    @Test
    void calculateSum_emptyArray_using_data_service(){
        when(someDataServiceMock.retriveAllData()).thenReturn(new int[]{});
        int actualResult=business.calculateSum_usingDataService();
        int expectedResult=0;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void calculateSum_oneValue_using_data_service(){
        when(someDataServiceMock.retriveAllData()).thenReturn(new int[]{1});
        int actualResult=business.calculateSum_usingDataService();
        int expectedResult=1;
        assertEquals(expectedResult,actualResult);
    }


    @Test
    void calculateSum_usingDataService(){
        when(someDataServiceMock.retriveAllData()).thenReturn(new int[]{1,2,3,4});
        int actualResult=business.calculateSum_usingDataService();
        assertEquals(10,actualResult);
    }





}