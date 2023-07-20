import core.Line;
import core.Station;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тестируем класс RouteCalculator")
public class RouteCalculatorTest {

    //[l1]               [l2]               [l3]
    //[l1]               [l2] -[пересадка]- [l3]
    //[l1] -[пересадка]- [l2]               [l3]

    StationIndex stationIndex = new StationIndex();
    RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

    Line line1 = new Line(1, "Первая");
    Line line2 = new Line(2, "Вторая");
    Line line3 = new Line(3, "Третья");

    Station lindenMountain = new Station("Липовая гора", line1);
    Station komsomolskayaSquare = new Station("Комсомольская площадь", line1);
    Station market = new Station("Рынок", line1);
    Station popova = new Station("Попова", line2);
    Station pinery = new Station("Сосоновый бор", line2);
    Station stadium = new Station("Стадион", line2);
    Station komsomolskyProspect = new Station("Комсомольский проспект", line3);
    Station circus = new Station("Цирк", line3);
    Station visim = new Station("ВИСИМ", line3);

    @BeforeEach
    public void setUp() {
        Stream.of(lindenMountain, komsomolskayaSquare, market, popova, pinery, stadium, komsomolskyProspect, circus,
                visim).peek(station -> station.getLine().addStation(station)).forEach(stationIndex::addStation);
        stationIndex.addConnection(Stream.of(market, stadium).collect(Collectors.toList()));
        stationIndex.addConnection(Stream.of(pinery, circus).collect(Collectors.toList()));
        stationIndex.getConnectedStations(market);
        stationIndex.getConnectedStations(pinery);
    }

    @Test
    @DisplayName("Тестируем время в пути")
    public void testCalculateDuration() {
        List<Station> timeTest = Stream.of(lindenMountain, komsomolskayaSquare, market, stadium, pinery)
                .collect(Collectors.toList());
        double actual = RouteCalculator.calculateDuration(timeTest);
        double expected = 11.0;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тестируем передвижение по одной линии")
    public void testGetShortestRoute() {
        List<Station> actual = routeCalculator.getShortestRoute(lindenMountain, market);
        List<Station> expected = Stream.of(lindenMountain, komsomolskayaSquare, market).collect(Collectors.toList());
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Тестируем передвижение с одной пересадкой")
    public void getRouteWithOneConnection() {
        List<Station> actual = routeCalculator.getShortestRoute(lindenMountain, popova);
        List<Station> expected = Stream.of(lindenMountain, komsomolskayaSquare, market, stadium, pinery, popova)
                .collect(Collectors.toList());
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Тестируем передвижение с двумя пересадками")
    public void getRouteWithTwoConnections() {
        List<Station> actual = routeCalculator.getShortestRoute(lindenMountain, komsomolskyProspect);
        List<Station> expected = Stream.of(lindenMountain, komsomolskayaSquare, market, stadium, pinery, circus,
                komsomolskyProspect).collect(Collectors.toList());
        assertEquals(actual, expected);
    }
}
