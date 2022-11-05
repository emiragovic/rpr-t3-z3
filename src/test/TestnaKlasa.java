import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.internal.debugging.MockitoDebuggerImpl;

import java.util.Map;

public class TestnaKlasa {

    @Test
    void Test1(){
        Map<String, String> mapa = Mockito.mock(Map.class);

        mapa.put("Emir", "Agović");
        mapa.put("Selma", "Ljuhar");
        mapa.put("Sebija", "Izetbegović");
        Mockito.verify(mapa).put("Emir", "Agović");
        Mockito.verify(mapa).put("Selma", "Ljuhar");
        Mockito.verify(mapa).put("Sebija", "Izetbegović");

        Mockito.when(mapa.get("Emir")).thenReturn("Ljuhar");

        Assertions.assertEquals(mapa.get("Emir"), "Ljuhar");

        Mockito.when(mapa.get("Sebija")).thenReturn("Ljuhar");

        Assertions.assertEquals(mapa.get("Sebija"), "Ljuhar");
    }

    @Test
    void Test2(){
        Bazna b = new Bazna();
        b.atribut = Mockito.mock(Izvedena.class);
        Mockito.when(b.atribut.metoda()).thenReturn(2);

        Assertions.assertEquals(b.metoda(), 2);

        Mockito.verify(b.atribut).metoda();
    }
}
