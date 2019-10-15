package es.ulpgc.dayron.spotifly.songs;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import es.ulpgc.dayron.spotifly.app.AppMediator;

public class SongsScreen {

  public static void configure(SongsContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    SongsState state = mediator.getSongsState();

    SongsContract.Router router = new SongsRouter(mediator);
    SongsContract.Presenter presenter = new SongsPresenter(state);
    SongsContract.Model model = new SongsModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
