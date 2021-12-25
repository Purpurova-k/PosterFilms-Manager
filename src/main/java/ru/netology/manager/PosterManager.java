package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;
import ru.netology.repository.PosterRepository;

@Data
@NoArgsConstructor

public class PosterManager {
    // создаем репозиторий
    private PosterRepository repository;

    public PosterManager(PosterRepository repository) {
        this.repository = repository;
    }


    //добавить фильм
    public void add(Film film) {
        repository.save(film);
    }


    // показать все фильмы из репозитория
    public Film[] getAll() {
        Film[] films = repository.findAll();
        Film[] result = new Film[films.length];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }


    // найти фильм
    public Film findById(int id) {
        return repository.findById(id);
    }


    // удалить фильм
    public void removeById(int id) {
        repository.removeById(id);
    }


    // удалить все фильмы
    public void removeAll() {
        repository.removeAll();
    }
}
