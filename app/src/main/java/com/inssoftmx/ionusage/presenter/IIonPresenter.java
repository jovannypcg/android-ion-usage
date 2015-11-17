package com.inssoftmx.ionusage.presenter;

/**
 * Provides methods to handle the logic in the IonView.
 *
 * @author  OCPJP Jovanny Pablo Cruz Gomez.
 *          Software Engineer.
 *
 * @version 1.0
 */
public interface IIonPresenter {
    /**
     * Sets up UI components of the view.
     */
    void setupView();

    /**
     * Consume the greeting service.
     */
    void consumeGreeting();
}
