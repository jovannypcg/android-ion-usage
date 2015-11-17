package com.inssoftmx.ionusage.presenter;

import com.google.gson.JsonObject;
import com.inssoftmx.ionusage.R;
import com.inssoftmx.ionusage.util.Constant;
import com.inssoftmx.ionusage.util.URL;
import com.inssoftmx.ionusage.view.IonView;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * Specifies the app logic.
 *
 * @author OCPJP Jovanny Pablo Cruz Gomez.
 *         Software Engineer.
 * @version 1.0
 */
public class IonPresenter implements IIonPresenter {
    /**
     * The view which is manipulated by this presenter.
     */
    private IonView view;

    /**
     * Constructor.
     *
     * @param view The view which is manipulated by this presenter.
     */
    public IonPresenter(IonView view) {
        this.view = view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setupView() {
        view.getProgressDialog().setTitle(view.getContext().getString(R.string.loading));
        view.getProgressDialog().setCancelable(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void consumeGreeting() {
        if (!view.getProgressDialog().isShowing()) {
            view.getProgressDialog().show();
        }

        Ion.with(view.getContext())
                .load(URL.GREETING)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        if (e != null) {
                            return;
                        }

                        actionConsumeGreeting(result);
                    }
                });
    }

    /**
     * Dismisses the progress bar when the service is consumed.
     * <p/>
     * Shows both, the JSON and human outputs.
     *
     * @param result The result from the web service.
     */
    private void actionConsumeGreeting(JsonObject result) {

        if (view.getProgressDialog().isShowing()) {
            view.getProgressDialog().dismiss();
        }

        showJsonOutput(result);
        showCleanOutput(result);
    }

    /**
     * Shows the result from the web service in JSON format.
     *
     * @param result The result from the web service.
     */
    private void showJsonOutput(JsonObject result) {
        view.getTextViewJsonOutput().setText(result.toString());
    }

    /**
     * Shows the result from the web service in human format.
     *
     * @param result The result from the web service.
     */
    private void showCleanOutput(JsonObject result) {
        view.getTextViewCleanOutput().setText(String.format("id: %s\n",
                result.get(Constant.ID_JSON_IDENTIFIER).getAsString()));

        view.getTextViewCleanOutput().append(String.format("content: %s\n",
                result.get(Constant.CONTENT_JSON_IDENTIFIER).getAsString()));
    }
}
