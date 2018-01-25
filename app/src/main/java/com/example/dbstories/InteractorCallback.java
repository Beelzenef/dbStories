package com.example.dbstories;

/**
 * Callback para comunicar repositorio con presenter
 * ante actualizaciones, inserciones o eliminaciones en la BD
 */

public interface InteractorCallback {

    void onError();
    void onSuccess();
}
