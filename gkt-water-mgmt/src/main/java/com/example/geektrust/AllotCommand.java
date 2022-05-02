package com.example.geektrust;


import org.jetbrains.annotations.NotNull;

public class AllotCommand {


	private @NotNull Apartment createApartment(int type, double ratio) {
		return new Apartment(type, ratio, 0);
	}

	private @NotNull Double parseRatio(@NotNull String s) {
		final String[] tokens = s.split(":");
		final int num = Integer.parseInt(tokens[0]);
		final int den = Integer.parseInt(tokens[1]);
		return num * 1.0 / (num + den);
	}

	public @NotNull Apartment parseCommand(@NotNull final String command) {
		final String[] tokens = command.split(" ");
		final int type = Integer.parseInt(tokens[1]);
		final String ratioStr = tokens[2];
		final Double ratio = parseRatio(ratioStr);
		return createApartment(type, ratio);
	}

}
