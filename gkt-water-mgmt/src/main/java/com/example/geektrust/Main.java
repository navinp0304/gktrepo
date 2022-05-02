package com.example.geektrust;

import org.jetbrains.annotations.NotNull;

public class Main {
    public static void main(String @NotNull [] args)  {
    	String filename = args[0];
    	CommandDispatch cp = new CommandDispatch(filename);
    	cp.run();
    	LogUtil logger = new LogUtil();
    	System.out.println(logger.readFirstLine());
	}
}
