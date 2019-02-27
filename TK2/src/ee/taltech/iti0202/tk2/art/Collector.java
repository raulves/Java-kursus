package ee.taltech.iti0202.tk2.art;

import java.util.ArrayList;
import java.util.List;

public class Collector {
    private List<Painting> paintings = new ArrayList<>();

    public boolean addPainting(Painting painting) {
        List<String> paint = new ArrayList<>();
        return false;
    }

    public boolean sellPainting(Painting painting, Collector fellowCollector) {
        return true;
    }

    public List<Painting> getPaintings() {
        return paintings;
    }
}
