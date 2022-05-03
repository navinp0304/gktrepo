package main.com.example.geektrust;

import java.util.function.Supplier;

public class RateBuilder {
    private static final double CORPORATIONRATE = 1.0;
    private static final double BOREWELLRATE = 1.5;
    private static final double[][] TANKERRATE = {
            { 1, 500, 2 }, { 501, 1500, 3 }, { 1501, 3000, 5 }, { 3001, Double.MAX_VALUE, 8 }
    };
    Apartment apartment;
    Supplier<double[]> borewellCorporationTankerCost = () -> {
        double totalLitres = 0.0;
        double totalCost = 0.0;
        double personLitresMonth = Apartment.getPERSONLITRESMONTH();

        totalLitres += Math
                .round((1.0 - apartment.getRatio()) * personLitresMonth * apartment.getResidents());
        totalCost += Math
                .round(1.0 - apartment.getRatio() * personLitresMonth * apartment.getResidents())
                * BOREWELLRATE;

        totalLitres += Math.round(apartment.getRatio() * personLitresMonth * apartment.getResidents());
        totalCost += Math.round(apartment.getRatio() * personLitresMonth * apartment.getResidents())
                * CORPORATIONRATE;

        double guestLitres = Math.round(apartment.getGuests() * personLitresMonth * 1.0);
        totalLitres += guestLitres;

        for (double[] slab : TANKERRATE) {
            totalCost += Math.max(0, (Math.min(guestLitres, slab[1]) - slab[0] + 1)) * slab[2];
        }

        return new double[] { totalLitres, Math.round(totalCost) };

    };

    public double[] getTotalCost() {
        return borewellCorporationTankerCost.get();

    }

};