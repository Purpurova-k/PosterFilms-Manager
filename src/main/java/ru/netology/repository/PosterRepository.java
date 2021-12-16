package ru.netology.repository;

import ru.netology.domain.Film;

public class PosterRepository {
    // Массив с фильмами
    private Film[] films = new Film[0];

    // Показывает все фильмы в массиве
    public Film[] findAll() {
        return films;
    }


    // Добавляет фильм в массив
    public void save(Film newFilm) {
        int length = films.length + 1;
        Film[] tmp = new Film[length];

        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newFilm;
        films = tmp;
    }


    // Находит фильм по id
    public Film findById(int id) {
        for (Film film : films) {
            if (film.getId() == id) {
                return film;
            }
        }
        return null;
    }


    // Удаляет фильм по id
    public void removeById (int id) {
        int length = films.length - 1;
        Film[] tmp = new Film[length];
        int index = 0;
        for (Film film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }


    // Полностью удаляет фильмы из репозитория
    public void removeAll() {
        films = new Film[0];
    }
}

