package model.factory;

import model.entity.Movie;

//CLASSE CRIADORA DE OBJETO FILME
public class MovieFactory {
    public static Movie createMovie(
            int id, String title, String language,
            String director, String[] genres, int releaseYear, int runtime
    ) {
        return new Movie(id,  title,  language, director,  genres, releaseYear, runtime);
    }
}
