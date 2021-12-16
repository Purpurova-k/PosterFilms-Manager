package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
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
    public void shouldAddFilm() {
        PosterManager manager = new PosterManager();
        manager.addFilm(bloodshot);
        Film[] expected = {bloodshot};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldGetFilms10() {
        PosterManager manager = new PosterManager(10);
        manager.addFilm(bloodshot);
        manager.addFilm(forward);
        manager.addFilm(hotelBelgrad);
        manager.addFilm(gentlemen);
        manager.addFilm(invisibleHuman);
        manager.addFilm(trolls);
        manager.addFilm(numberOne);
        manager.addFilm(avatar);
        manager.addFilm(onlyYou);
        manager.addFilm(okulus);
        Film[] expected = {okulus, onlyYou, avatar, numberOne, trolls, invisibleHuman, gentlemen, hotelBelgrad, forward, bloodshot};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldGetFilms10WhenAdded11() {
        PosterManager manager = new PosterManager(10);
        manager.addFilm(bloodshot);
        manager.addFilm(forward);
        manager.addFilm(hotelBelgrad);
        manager.addFilm(gentlemen);
        manager.addFilm(invisibleHuman);
        manager.addFilm(trolls);
        manager.addFilm(numberOne);
        manager.addFilm(avatar);
        manager.addFilm(onlyYou);
        manager.addFilm(okulus);
        manager.addFilm(mother);
        Film[] expected = {mother, okulus, onlyYou, avatar, numberOne, trolls, invisibleHuman, gentlemen, hotelBelgrad, forward};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldGetFilms5() {
        PosterManager manager = new PosterManager(5);
        manager.addFilm(bloodshot);
        manager.addFilm(forward);
        manager.addFilm(hotelBelgrad);
        manager.addFilm(gentlemen);
        manager.addFilm(invisibleHuman);
        Film[] expected = {invisibleHuman, gentlemen, hotelBelgrad, forward, bloodshot};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldGetFilms2WhenAdded3() {
        PosterManager manager = new PosterManager(2);
        manager.addFilm(bloodshot);
        manager.addFilm(forward);
        manager.addFilm(hotelBelgrad);
        Film[] expected = {hotelBelgrad, forward};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}