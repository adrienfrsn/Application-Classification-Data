package fr.univlille.s3.S302.model;

public interface Observer<E> {

    void update(Observable<E> ob);

    void update(Observable<E> ob, E elt);
}
