package GeekBrains.OOP.Sem3.Zad3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StreamService {
    private ArrayList<Stream> streamList;

    public StreamService(ArrayList<Stream> streamList) {
        this.streamList = streamList;
    }

    public void sort() {
        Collections.sort(streamList, new StreamComparator());
    }

    @Override
    public String toString() {
        return "StreamService{" +
                "streamList=" + streamList +
                '}';
    }
}
