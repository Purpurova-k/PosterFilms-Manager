package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class PosterRepositoryTest {
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

    private PosterRepository repository = new PosterRepository();

    @Test
    public void shouldAddFilm() {
        repository.save(bloodshot);
        Film[] expected = {bloodshot};
        Film[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotShowMoreThan10Films() {
        repository.save(bloodshot);
        repository.save(forward);
        repository.save(hotelBelgrad);
        repository.save(gentlemen);
        repository.save(invisibleHuman);
        repository.save(trolls);
        repository.save(numberOne);
        repository.save(avatar);
        repository.save(onlyYou);
        repository.save(okulus);
        repository.save(mother);
        Film[] expected = {mother, okulus, onlyYou, avatar, numberOne, trolls, invisibleHuman, gentlemen, hotelBelgrad, forward};
        Film[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        repository.save(bloodshot);
        repository.save(invisibleHuman);
        repository.save(okulus);
        Film[] expected = {okulus, invisibleHuman, bloodshot};
        Film[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByValidId() {
        Film[] films = {bloodshot, forward, hotelBelgrad};
        for (Film film : films) {
            repository.save(film);
        }
        Film expected = hotelBelgrad;
        Film actual = repository.findById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByInvalidId() {
        Film[] films = {bloodshot, forward, hotelBelgrad};
        for (Film film : films) {
            repository.save(film);
        }
        Film actual = repository.findById(300);
        assertNull(actual);
    }

    @Test
    public void shouldRemoveById() {
        Film[] films = {avatar, okulus, onlyYou};
        for (Film film : films) {
            repository.save(film);
        }
        repository.removeById(8);
        Film[] expected = {onlyYou, okulus};
        Film[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        Film[] films = {avatar, okulus, onlyYou};
        repository.removeAll();
        Film[] expected = {};
        Film[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}

