package main.java;

public class Input {
    private StringBuilder sb = new StringBuilder();

    public StringBuilder append(String input) {
        return sb.append(input);
    }

    public int len() {
        return sb.length();
    }

    public void clear() {
        sb.setLength(0);
    }

    public String toString() {
        return sb.toString();
    }
}
