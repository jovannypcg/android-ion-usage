package com.inssoftmx.ionusage.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.TextView;

/**
 * Provides methods to get GUI controls from the
 * view. These controls are handled by the presenter.
 *
 * @author  OCPJP Jovanny Pablo Cruz Gomez.
 *          Software Engineer.
 *
 * @version 1.0
 */
public interface IonView {
    /**
     * Gets the text view which will show the web service result in JSON format.
     * @return TextView which will show the web service result in JSON format.
     */
    TextView getTextViewJsonOutput();

    /**
     * Gets the text view which will show the web service result in human format.
     * @return TextView which will show the web service result in human format.
     */
    TextView getTextViewCleanOutput();

    /**
     * Gets the progress dialog of the view.
     * @return The progress dialog.
     */
    ProgressDialog getProgressDialog();

    /**
     * Gets the context of the view.
     * @return The context of the view.
     */
    Context getContext();
}
