package es.ulpgc.dayron.spotifly.app;

import android.app.Application;

import es.ulpgc.dayron.spotifly.addSongs.AddSongsState;
import es.ulpgc.dayron.spotifly.forgotPassword.ForgotPasswordState;
import es.ulpgc.dayron.spotifly.friendSong.FriendSongState;
import es.ulpgc.dayron.spotifly.login.LoginState;
import es.ulpgc.dayron.spotifly.player.PlayerState;
import es.ulpgc.dayron.spotifly.register.RegisterState;
import es.ulpgc.dayron.spotifly.songs.SongsState;
import es.ulpgc.dayron.spotifly.users.UsersState;

public class AppMediator extends Application {

    private LoginState loginState;
    private SongsState songsState;
    private RegisterState registerState;
    private PlayerState playerState;
    private FriendSongState friendSongState;
    private ForgotPasswordState forgotPasswordState;
    private AddSongsState addSongsState;
    private UsersState usersState;
    private Song song;
    private String songTitle;

    public AppMediator() {
        loginState = new LoginState();
        songsState = new SongsState();
        registerState = new RegisterState();
        playerState = new PlayerState();
        friendSongState = new FriendSongState();
        forgotPasswordState = new ForgotPasswordState();
        addSongsState = new AddSongsState();
        songTitle = "";
        usersState = new UsersState();
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

    public void setSong(Song item) {
        this.song = item;
    }

    public Song getSong() {
        return song;
    }

    public void setSongsTitle(String title) {
    }

    public String getSongTitle() {
        return songTitle;
    }

    public UsersState getUsersState() {
        return usersState;
    }

    public void setUsersState(UsersState state) {
        this.usersState = state;
    }
}
