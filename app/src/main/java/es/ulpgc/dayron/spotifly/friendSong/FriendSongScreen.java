package es.ulpgc.dayron.spotifly.friendSong;

import java.lang.ref.WeakReference;
import androidx.fragment.app.FragmentActivity;
import es.ulpgc.dayron.spotifly.app.AppMediator;

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
