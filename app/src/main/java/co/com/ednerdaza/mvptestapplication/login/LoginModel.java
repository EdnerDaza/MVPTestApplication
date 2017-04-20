package co.com.ednerdaza.mvptestapplication.login;

import android.os.Handler;
import android.text.TextUtils;

public class LoginModel implements LoginModelInterface{

    @Override
    public void auth(final String username, final String password, final LoginCallback listener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                if(!TextUtils.isEmpty(username)&&!(TextUtils.isEmpty(password))) {
                    listener.onSuccess();
                }else{
                    listener.onError();
                }
            }
        }, 2000);
    }

}
