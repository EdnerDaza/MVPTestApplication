package co.com.ednerdaza.mvptestapplication.login;

public class LoginPresenter implements LoginPresenterInterface, LoginCallback {

    private final LoginView view;
    private final LoginModelInterface model;

    public LoginPresenter(LoginView view, LoginModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void validateCredentials(String username, String password) {
        model.auth(username, password, this);
    }

    @Override
    public void onSuccess() {
        view.showMain();
    }

    @Override
    public void onError() {
        view.showError();
    }
}
