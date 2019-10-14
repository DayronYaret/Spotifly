package es.ulpgc.dayron.spotifly.player;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class PlayerScreen {

  public static void configure(PlayerContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    PlayerState state = mediator.getPlayerState();

    PlayerContract.Router router = new PlayerRouter(mediator);
    PlayerContract.Presenter presenter = new PlayerPresenter(state);
    PlayerContract.Model model = new PlayerModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
