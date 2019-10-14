package es.ulpgc.dayron.spotifly.friends;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class FriendsScreen {

  public static void configure(FriendsContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    FriendsState state = mediator.getFriendsState();

    FriendsContract.Router router = new FriendsRouter(mediator);
    FriendsContract.Presenter presenter = new FriendsPresenter(state);
    FriendsContract.Model model = new FriendsModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
