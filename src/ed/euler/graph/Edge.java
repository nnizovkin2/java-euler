package ed.euler.graph;

import java.util.Objects;

public class Edge implements Comparable<Edge>{
    int x;
    int y;

    public Edge(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return x == edge.x && y == edge.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Edge o) {
        return x == o.x ? Integer.compare(y, o.y) : Integer.compare(x, o.x);
    }
}
