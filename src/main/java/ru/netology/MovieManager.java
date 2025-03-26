package ru.netology;

public class MovieManager {
    private String[] moviesList = new String[0];
    private int limit;


    public MovieManager() {
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }


    public void addMovie(String movie) {
        String[] tmp = new String[moviesList.length + 1];
        for (int i = 0; i < moviesList.length; i++) {
            tmp[i] = moviesList[i];
        }
        tmp[tmp.length - 1] = movie;
        moviesList = tmp;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int newLimit) {
        this.limit = newLimit;
    }

    public String[] findAll() {
        return moviesList;
    }

    public String[] findLast() {
        int resultLength;
        String[] all = moviesList;

        if (limit >= moviesList.length) {
            resultLength = moviesList.length;
        } else {
            resultLength = limit;
        }
        String[] result = new String[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = all[all.length - 1 - i];
        }
        return result;
    }
}
