package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    MovieManager manager = new MovieManager();

    @Test
    public void shouldDefaultLimitWork() {

        int expected = 5;
        int actual = manager.getLimit();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSpecifiedLimitWork( ) {
        MovieManager manager = new MovieManager(6);

        int expected = 6;
        int actual = manager.getLimit();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldMoviesAddedAndShow() {

        manager.addMovie("Movie1");
        manager.addMovie("Movie2");
        manager.addMovie("Movie3");
        manager.addMovie("Movie4");
        manager.addMovie("Movie5");

        String[] expected = {"Movie1", "Movie2", "Movie3", "Movie4", "Movie5"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMoviesEqualsLimit () {

        manager.addMovie("Movie1");
        manager.addMovie("Movie2");
        manager.addMovie("Movie3");
        manager.addMovie("Movie4");
        manager.addMovie("Movie5");

        String[] expected = {"Movie5", "Movie4", "Movie3", "Movie2", "Movie1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMoviesMoreLimit () {

        MovieManager manager = new MovieManager(3);

        manager.addMovie("Movie1");
        manager.addMovie("Movie2");
        manager.addMovie("Movie3");
        manager.addMovie("Movie4");
        manager.addMovie("Movie5");

        String[] expected = {"Movie5", "Movie4", "Movie3"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMoviesLessLimit () {

        MovieManager manager = new MovieManager(4);

        manager.addMovie("Movie1");
        manager.addMovie("Movie2");

        String[] expected = {"Movie2", "Movie1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
