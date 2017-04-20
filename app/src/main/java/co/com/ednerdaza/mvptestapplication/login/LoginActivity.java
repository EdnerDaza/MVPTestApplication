package co.com.ednerdaza.mvptestapplication.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.com.ednerdaza.mvptestapplication.R;
import co.com.ednerdaza.mvptestapplication.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener{

    private EditText username;
    private EditText password;
    private LoginPresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);

        presenter = new LoginPresenter(this, new LoginModel());
    }

    @Override
    public void onClick(View v) {
        presenter.validateCredentials(getUsername(), getPassword());
    }

    @Override
    public void showMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void showError() {
        Toast.makeText(this, getResources().getText(R.string.login_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }
}
