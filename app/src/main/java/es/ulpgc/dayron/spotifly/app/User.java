package es.ulpgc.dayron.spotifly.app;

public class User {
  private String username;
  private String email;
  private String uId;

  public User(String username, String email){
    this.username=username;
    this.email=email;
  }
  public  User(String username, String email, String uId){
    this.username=username;
    this.email=email;
    this.uId=uId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getuId() {
    return uId;
  }

  public void setuId(String uId) {
    this.uId = uId;
  }
}
