package main.java;

import java.util.ArrayList;
import java.util.List;

import static main.java.Operator.*;

public class Expression {
    private List<Integer> arguments = new ArrayList<>();

    public Expression append(Integer integer) {
        arguments.add(integer);
        return this;
    }

    @Override
    public String toString() {
        return arguments.toString();
    }

    public int evaluate(String operator) {
        int res = 0;
        if (arguments.size() == 1) {
            return arguments.get(0);
        }
        if (arguments.size() == 0) {
            return 0;
        }

        switch (operator) {
            case MINUS:
                res = arguments.get(0) - arguments.get(1);
                break;
            case PLUS:
                res = arguments.get(0) + arguments.get(1);
                break;
            case EQUALS:
                arguments.clear();
        }
        return res;
    }
}
