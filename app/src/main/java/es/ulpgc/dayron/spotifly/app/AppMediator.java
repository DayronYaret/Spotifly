package es.ulpgc.dayron.spotifly.app;

import android.app.Application;

import es.ulpgc.dayron.spotifly.login.LoginState;

public class AppMediator extends Application {
  private LoginState loginState;

  public AppMediator(){
    loginState = new LoginState();
  }

  public LoginState getLoginState() {
    return loginState;
  }
  public void setLoginState(LoginState state){
    this.loginState=state;
  }
}
