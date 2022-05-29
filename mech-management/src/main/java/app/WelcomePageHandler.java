package app;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class WelcomePageHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        ctx.result("Welcome to Group 5 Project 2 Java Handler Page!!!");
    }
}
