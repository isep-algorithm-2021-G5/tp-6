package a;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int label;
    private List<Integer> neighbors = new ArrayList<>();
    private boolean isVisited = false;

    public int getLabel() {

        return label;
    }

    public void setLabel(int label) {

        this.label = label;
    }

    public List<Integer> getNeighbors () {

        return neighbors;
    }

    public boolean getIsVisited() {

        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {

        this.isVisited = isVisited;
    }
}
