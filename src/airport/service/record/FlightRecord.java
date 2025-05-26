package airport.service.record;

public record FlightRecord(

        String id,
        String planeId,
        String departureLocationId,
        String arrivalLocationId,
        String scaleLocationId,
        int year,
        int month,
        int day,
        int hour,
        int minutes,
        int hoursDurationsArrival,
        int minutesDurationsArrival,
        int hoursDurationsScale,
        int minutesDurationsScale) {
}