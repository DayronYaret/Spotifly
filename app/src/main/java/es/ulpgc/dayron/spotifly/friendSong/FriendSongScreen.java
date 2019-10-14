package es.ulpgc.dayron.spotifly.friendSong;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class FriendSongScreen {

  public static void configure(FriendSongContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    FriendSongState state = mediator.getFriendSongState();

    FriendSongContract.Router router = new FriendSongRouter(mediator);
    FriendSongContract.Presenter presenter = new FriendSongPresenter(state);
    FriendSongContract.Model model = new FriendSongModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
