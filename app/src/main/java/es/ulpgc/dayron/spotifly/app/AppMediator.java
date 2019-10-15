package es.ulpgc.dayron.spotifly.app;

import android.app.Application;

import es.ulpgc.dayron.spotifly.addFriends.AddFriendsState;
import es.ulpgc.dayron.spotifly.addSongs.AddSongsState;
import es.ulpgc.dayron.spotifly.forgotPassword.ForgotPasswordState;
import es.ulpgc.dayron.spotifly.friendSong.FriendSongState;
import es.ulpgc.dayron.spotifly.friends.FriendsState;
import es.ulpgc.dayron.spotifly.login.LoginState;
import es.ulpgc.dayron.spotifly.player.PlayerState;
import es.ulpgc.dayron.spotifly.register.RegisterState;
import es.ulpgc.dayron.spotifly.songs.SongsState;

public class AppMediator extends Application {

    private LoginState loginState;
    private SongsState songsState;
    private RegisterState registerState;
    private PlayerState playerState;
    private FriendSongState friendSongState;
    private FriendsState friendsState;
    private ForgotPasswordState forgotPasswordState;
    private AddSongsState addSongsState;
    private AddFriendsState addFriendsState;

    public AppMediator() {
        loginState = new LoginState();
        songsState = new SongsState();
        registerState = new RegisterState();
        playerState= new PlayerState();
        friendSongState = new FriendSongState();
        friendsState = new FriendsState();
        forgotPasswordState= new ForgotPasswordState();
        addSongsState = new AddSongsState();
        addFriendsState = new AddFriendsState();
    }


    public LoginState getLoginState() {
        return loginState;
    }

    public void setLoginState(LoginState loginState) {
        this.loginState = loginState;
    }

    public SongsState getSongsState() {
        return songsState;
    }

    public void setSongsState(SongsState songsState) {
        this.songsState = songsState;
    }

    public RegisterState getRegisterState() {
        return registerState;
    }

    public void setRegisterState(RegisterState registerState) {
        this.registerState = registerState;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public FriendSongState getFriendSongState() {
        return friendSongState;
    }

    public void setFriendSongState(FriendSongState friendSongState) {
        this.friendSongState = friendSongState;
    }

    public FriendsState getFriendsState() {
        return friendsState;
    }

    public void setFriendsState(FriendsState friendsState) {
        this.friendsState = friendsState;
    }

    public ForgotPasswordState getForgotPasswordState() {
        return forgotPasswordState;
    }

    public void setForgotPasswordState(ForgotPasswordState forgotPasswordState) {
        this.forgotPasswordState = forgotPasswordState;
    }

    public AddSongsState getAddSongsState() {
        return addSongsState;
    }

    public void setAddSongsState(AddSongsState addSongsState) {
        this.addSongsState = addSongsState;
    }

    public AddFriendsState getAddFriendsState() {
        return addFriendsState;
    }

    public void setAddFriendsState(AddFriendsState addFriendsState) {
        this.addFriendsState = addFriendsState;
    }
}
