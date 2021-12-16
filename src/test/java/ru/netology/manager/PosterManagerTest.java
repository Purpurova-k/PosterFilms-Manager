package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Film;
import ru.netology.repository.PosterRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PosterManagerTest {
    private PosterRepository repository = Mockito.mock(PosterRepository.class);

    private PosterManager manager = new PosterManager(repository);

    Film bloodshot = new Film(1, "Bloodshot", "action", false, "Image");
    Film forward = new Film(2, "Forward", "cartoon", false, "Image");
    Film hotelBelgrad = new Film(3, "Hotel Belgrad", "comedy", false, "Image");
    Film gentlemen = new Film(4, "Gentlemen", "action", false, "Image");
    Film invisibleHuman = new Film(5, "Invisible Human", "horror", false, "Image");
    Film trolls = new Film(6, "Trolls", "cartoon", true, "Image");
    Film numberOne = new Film(7, "Number One", "comedy", true, "Image");
    Film avatar = new Film(8, "Avatar", "action", false, "Image");
    Film onlyYou = new Film(9, "Only You", "drama", true, "Image");
    Film okulus = new Film(10, "Okulus", "horror", false, "Image");
    Film mother = new Film(11, "Mother", "drama", true, "Image");

    @Test
    public void shouldReturnFilms() {
        Film[] returned = {bloodshot, forward, hotelBelgrad};
        doReturn(returned).when(repository).findAll();
        manager.add(bloodshot);
        manager.add(forward);
        manager.add(hotelBelgrad);
        Film[] expected = {hotelBelgrad, forward, bloodshot};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }


    @Test
    public void shouldFindByValidId() {
        Film returned = mother;
        doReturn(returned).when(repository).findById(11);
        Film expected = mother;
        Film actual = manager.findById(11);
        assertEquals(expected, actual);

        verify(repository).findById(11);
    }


    @Test
    public void shouldFindByInvalidId() {
        doReturn(null).when(repository).findById(100);
        Film actual = manager.findById(100);
        assertNull(actual);

        verify(repository).findById(100);
    }


    @Test
    public void shouldRemoveById() {
        Film[] returned = {bloodshot, forward};
        doReturn(returned).when(repository).findAll();
        manager.add(bloodshot);
        manager.add(forward);
        manager.add(hotelBelgrad);
        manager.removeById(3);
        Film[] expected = {forward, bloodshot};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).removeById(3);
    }


    @Test
    public void shouldRemoveAll() {
        Film[] returned = {};
        doReturn(returned).when(repository).findAll();
        manager.add(okulus);
        manager.add(forward);
        manager.add(mother);
        manager.removeAll();
        Film[] expected = {};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).removeAll();
    }


}