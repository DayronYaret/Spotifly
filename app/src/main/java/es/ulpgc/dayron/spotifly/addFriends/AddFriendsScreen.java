package es.ulpgc.dayron.spotifly.addFriends;

import java.lang.ref.WeakReference;
import androidx.fragment.app.FragmentActivity;
import es.ulpgc.dayron.spotifly.app.AppMediator;

public class AddFriendsScreen {

  public static void configure(AddFriendsContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AddFriendsState state = mediator.getAddFriendsState();

    AddFriendsContract.Router router = new AddFriendsRouter(mediator);
    AddFriendsContract.Presenter presenter = new AddFriendsPresenter(state);
    AddFriendsContract.Model model = new AddFriendsModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
