package sample;

interface Dao2<T> {

    void create(String name, int artistId, int releaseYear);

    void findByArtist(int artistId);
}

