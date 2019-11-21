package es.ulpgc.dayron.spotifly.userSong;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;
import es.ulpgc.dayron.spotifly.app.AppMediator;
import es.ulpgc.dayron.spotifly.app.Repository;
import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public class UserSongScreen {

  public static void configure(UserSongContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    UserSongState state = mediator.getUserSongState();

    RepositoryContract repository = Repository.getInstance(context.get());
    UserSongContract.Router router = new UserSongRouter(mediator);
    UserSongContract.Presenter presenter = new UserSongPresenter(state);
    UserSongContract.Model model = new UserSongModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
