class NodePQ {
    int x, y, distance, numPQ;

    public NodePQ(int x, int y) {
        this.x = x; // משקל של הצלע האופקי
        this.y = y; // משקל של הצלע האנכי
        this.distance = 0;
        this.numPQ = 0;
    }

    @Override
    public String toString() {
        return "{" + "(" + x + ", " + y + "), d=" + distance + ", n=" + numPQ + '}';
    }
}