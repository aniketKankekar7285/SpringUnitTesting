package business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
public class ListMockTest {

    List<String> mck= mock(List.class);
    @Test
    public void size_basic(){
        when(mck.size()).thenReturn(5).thenReturn(10).thenReturn(20);
        assertEquals(5,mck.size());
        assertEquals(10,mck.size());
        assertEquals(20,mck.size());
    }

    @Test
    public void returnWithParameters(){
        when(mck.get(0)).thenReturn("Aniket").thenReturn("Kankekar");
        assertEquals("Aniket",mck.get(0));
        assertEquals(null,mck.get(4));
    }
    @Test
    public void returnWithGenericParameters(){
        when(mck.get(anyInt())).thenReturn("AniketKankekar");
        assertEquals("AniketKankekar",mck.get(2));
        assertEquals("AniketKankekar",mck.get(7));
    }

    @Test
    public void verificationBasics(){
        String val= mck.get(0);
        String val2=mck.get(1);
        verify(mck).get(0);
        verify(mck,times(2)).get(anyInt());
        verify(mck,never()).get(2);
    }

    //argument capturing
    @Test
    public void argumentCapturing(){
        //SUT
        mck.add("Aniket");
        ArgumentCaptor<String > captor=ArgumentCaptor.forClass(String.class);
        verify(mck).add(captor.capture());
        assertEquals("Aniket",captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing(){
        mck.add("SomeString1");
        mck.add("SomeString2");
        ArgumentCaptor<String> captor= ArgumentCaptor.forClass(String.class);
        verify(mck,times(2)).add(captor.capture());
        List<String> allValues=captor.getAllValues();
        assertEquals("SomeString1",allValues.get(0));
        assertEquals("SomeString2",allValues.get(1));
    }

    @Test
    public void mocking(){
        ArrayList<String> arrayListMock=mock(ArrayList.class);
        arrayListMock.size(); //0
        arrayListMock.add("1213232");
        arrayListMock.size(); //0
        arrayListMock.add("jdfhfdyery");
        arrayListMock.add("yrygfiery");
        arrayListMock.get(0); //null
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); //5
    }

    @Test
    public void spying(){
        ArrayList<String> arrayListSpy=spy(ArrayList.class);
        arrayListSpy.size(); //0
        arrayListSpy.add("1213232");
        arrayListSpy.size(); //0
        arrayListSpy.add("jdfhfdyery");
        arrayListSpy.add("yrygfiery");
        arrayListSpy.get(0); //null
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); //5
        verify(arrayListSpy,times(3)).size();
    }


}
