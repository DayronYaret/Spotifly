package es.ulpgc.dayron.spotifly.app;

public class Song {
  private String url, title, artist;

  public Song(String url, String title, String artist){
    this.url=url;
    this.title=title;
    this.artist=artist;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }
}
