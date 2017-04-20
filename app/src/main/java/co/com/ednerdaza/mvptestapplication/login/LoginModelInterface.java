package co.com.ednerdaza.mvptestapplication.login;

public interface LoginModelInterface {
    public void auth(String username, String password, LoginCallback listener);
}
