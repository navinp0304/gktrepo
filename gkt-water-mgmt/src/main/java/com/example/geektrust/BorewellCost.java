package com.example.geektrust;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
public class BorewellCost implements IRateCalculator {

    public @NotNull Double[] getCost(@NotNull Apartment apt) {
		double litres = apt.getResidents() * Apartment.getPERSONLITRESMONTH() * (1.0 - apt.getRatioCORPORATIONBOREWELL());
		litres =  Math.round(litres);
        double BOREWELLRATE = 1.5;
        Double cost =  (litres * BOREWELLRATE);
		return new Double[] {litres, cost};
	}

}
