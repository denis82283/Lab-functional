package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class ConcertRepositoryTest {
    ConcertRepository concertRepository;

    @Before
    public void init() {
        var date = new GregorianCalendar(2020, Calendar.JANUARY, 1);
        var concert = new Concert("Rock and Dance", date, 2000);

        var acdc = new Singer("AC/DC", "+100000", 10, 5, false, "Rock");
        var rammstein = new Singer("Rammstein", "+1000076001", 10, 10, true, "Rock");
        var trs = new Singer("The Rolling Stones", "+100000002", 7, 6, true, "Rock");
        concert.inviteArtist(acdc);
        concert.inviteArtist(rammstein);
        concert.inviteArtist(trs);

        var vv = new Dancer("Владимир Варнава", "+70005400", 4, 8, false, "Hip hop");
        var mg = new Dancer("Martha Graham", "+100066801", 6, 12, true, "Own");
        var fa = new Dancer("Fred Astaire", "+10013002", 7, 6, true, "Musical Comedian");
        concert.inviteArtist(vv);
        concert.inviteArtist(mg);
        concert.inviteArtist(fa);

        var mark = new Staff(StaffType.Engineer, "Mark");
        var dan = new Staff(StaffType.Stewart, "Dan");
        var bob = new Staff(StaffType.Organizer, "Bob");

        dan.getConnectedArtists().add(acdc);
        dan.getConnectedArtists().add(rammstein);
        bob.getConnectedArtists().add(trs);
        bob.getConnectedArtists().add(vv);
        bob.getConnectedArtists().add(mg);

        concert.addStaff(mark);
        concert.addStaff(dan);
        concert.addStaff(bob);
        concert.addStaff(bob);

        concertRepository = new ConcertRepository(concert);
    }

    @Test
    public void EmptyFindArtistsShouldReturnAllArtists() {
        var count = concertRepository.findArtists().count();

        assertEquals(count, 6);
    }

    @Test
    public void SingerArtistPredicateShouldReturnTrueOnSinger() {
        var acdc = new Singer("AC/DC", "+100000", 10, 5, false, "Rock");

        var result = ConcertRepository.singerArtists().test(acdc);

        assertTrue(result);
    }

    @Test
    public void SingerArtistPredicateShouldReturnFalseOnNonSinger() {
        var mg = new Dancer("Martha Graham", "+100066801", 6, 12, true, "Own");

        var result = ConcertRepository.singerArtists().test(mg);

        assertFalse(result);
    }

    @Test
    public void FindArtistsWithPredicateShouldReturnRightValue() {
        var count = concertRepository
                .findArtists(ConcertRepository.singerArtists())
                .count();

        assertEquals(count, 3);
    }

    @Test
    public void SumSingerTeamCountShouldReturnRightValue() {
        var result = concertRepository.sumSingerTeamCount();

        assertEquals(result, 21);
    }

    @Test
    public void MostPopularArtistShouldBeAcdc() {
        var result = concertRepository.getMostPopularArtist();

        assertEquals(result.getName(), "AC/DC");
    }
}
