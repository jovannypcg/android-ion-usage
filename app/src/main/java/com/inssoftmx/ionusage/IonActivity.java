package com.inssoftmx.ionusage;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.inssoftmx.ionusage.presenter.IIonPresenter;
import com.inssoftmx.ionusage.presenter.IonPresenter;
import com.inssoftmx.ionusage.view.IonView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Shows Ion in action.
 * Provides GUI controls to the presenter.
 *
 * @author  OCPJP Jovanny Pablo Cruz Gomez.
 *          Software Engineer.
 *
 * @version 1.0
 */
public class IonActivity extends AppCompatActivity implements IonView, View.OnClickListener {
    /**
     * Button to consume the web service.
     */
    @Bind(R.id.btn_cosume)      Button btnConsume;

    /**
     * Show the web service result in JSON format.
     */
    @Bind(R.id.tv_json_output)  TextView tvJsonOutput;

    /**
     * Show the web service result in 'human' format.
     */
    @Bind(R.id.tv_clean_output) TextView tvCleanOutput;

    /**
     * Progress dialog.
     */
    private ProgressDialog progressDialog;

    /**
     * The presenter of this view.
     */
    private IIonPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        initProperties();
    }

    /**
     *
     */
    private void initProperties() {
        progressDialog = new ProgressDialog(this);
        presenter = new IonPresenter(this);

        presenter.setupView();

        btnConsume.setOnClickListener(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TextView getTextViewJsonOutput() {
        return tvJsonOutput;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TextView getTextViewCleanOutput() {
        return tvCleanOutput;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cosume:
                presenter.consumeGreeting();

                break;
        }
    }
}
