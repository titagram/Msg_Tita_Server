package common;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
    private static final List<String> bufferMsg = new ArrayList<>();

    public Buffer() {
    }

    public static void aggiungiMessaggio(String messaggio) {
        bufferMsg.add(messaggio);
    }


}
