package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcertRepository {
    Concert concert;

    public ConcertRepository(Concert concert) {
        this.concert = concert;
    }

    public Stream<Artist> findArtists() {
        return concert.getArtists().stream();
    }

    public Stream<Artist> findArtists(Predicate<? super Artist> filter) {
        return findArtists().filter(filter);
    }

    public int sumSingerTeamCount() {
        return findArtists(singerArtists())
                .reduce(0, (sum, artist) -> sum + artist.team.getPersonsCount(), Integer::sum);
    }

    public double calcAverageStaffArtistsRating() {
        return concert.getStaff().stream()
                .flatMap(staff -> staff.getConnectedArtists().stream())
                .mapToDouble(Artist::getPopularity)
                .average()
                .orElse(Double.NaN);
    }

    public Artist getMostPopularArtist() {
        return findArtists()
                .max(Comparator.comparing(Artist::getPopularity))
                .orElseThrow(NoSuchElementException::new);
    }

    public static Predicate<Artist> singerArtists() {
        return artist -> artist instanceof Singer;
    }

    public Map<String, List<Artist>> groupArtistByPopularity(Predicate<? super Artist> filter) {
        return findArtists(filter)
                .collect(Collectors.groupingBy(artist -> artist.popularity >= 8 ? "popular" : "not popular"));
    }
}
