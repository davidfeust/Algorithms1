class Node {
    int x, y, distance, num;

    public Node(int x, int y) {
        this.x = x; // משקל של הצלע האופקי
        this.y = y; // משקל של הצלע האנכי
        this.distance = 0;
        this.num = 0;
    }

    @Override
    public String toString() {
        return "{" + "(" + x + ", " + y + "), d=" + distance + ", n=" + num + '}';
    }
}