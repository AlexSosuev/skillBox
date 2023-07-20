import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(findPlanesLeavingInTheNextTwoHours(Airport.getInstance()));
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        LocalDateTime vMomente = LocalDateTime.now();
        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream()
                        .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE)))
                .filter(flight -> getLocalDateTime(flight).isAfter(vMomente)
                        && getLocalDateTime(flight).isBefore(vMomente.plusHours(2)))
                .collect(Collectors.toList());
    }

    private static LocalDateTime getLocalDateTime(Flight flight) {
        return flight.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}