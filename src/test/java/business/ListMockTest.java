package business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ListMockTest {

    List mck= mock(List.class);
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


}
