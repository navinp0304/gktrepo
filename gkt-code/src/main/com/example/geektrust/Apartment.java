package main.com.example.geektrust;

import lombok.Getter;
import lombok.Setter;

public class Apartment {
    @Getter
    private static final int PERSONLITRESMONTH = 300;
    @Getter
    int residents;
    @Getter @Setter
    int guests;
    @Getter
    double ratio;
    
    Apartment(int residents,int guests,double ratio){
        this.residents = residents;
        this.guests = guests;
        this.ratio = ratio;
    }
}
