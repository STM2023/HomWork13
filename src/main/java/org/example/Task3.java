package org.example;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Task3 {

    private static final String GET_TODOS_URI="https://jsonplaceholder.typicode.com/users/1/todos";

    public static void main(String[] args) throws  IOException, InterruptedException {

       // int X = 1;

        List<Todos> allTodos  = new ArrayList<Todos>();

        final List<Todos> todos = HttpUtil.sendGetWithListOfResults3(URI.create(GET_TODOS_URI));

        System.out.println("task3");
        for (Todos o: todos ) {
            if (!o.isCompleted()) {
                allTodos.add(o);
                System.out.println(o );
            }
        }

      //  System.out.println("Todos list " + allTodos);
    }
}


