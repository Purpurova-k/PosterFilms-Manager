package ru.netology.manager;

import ru.netology.domain.Film;

public class PosterManager {

    // Создаем пустой репозиторий для хранения фильмов
    private Film[] films = new Film[0];

    // Макс кол-во фильмов который должен выводить менеджер
    private int countFilms = 10;

    public PosterManager(int countFilms) {
        this.countFilms = countFilms;
    }

    public PosterManager() {
    }


    // Добавление фильма
    public void addFilm(Film newFilm) {
        int length = films.length + 1;
        Film[] tmp = new Film[length];

        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newFilm;
        films = tmp;
    }

    // Показать все добавленные фильмы (не более 10)
    public Film[] getAll() {
        int resultLength;
        if (films.length > countFilms) {
            resultLength = countFilms;
        } else {
            resultLength = films.length;
        }
        Film[] result =  new Film[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}
