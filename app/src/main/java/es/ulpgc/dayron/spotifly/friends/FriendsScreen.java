package es.ulpgc.dayron.spotifly.friends;

import java.lang.ref.WeakReference;
import androidx.fragment.app.FragmentActivity;
import es.ulpgc.dayron.spotifly.app.AppMediator;
import es.ulpgc.dayron.spotifly.app.Repository;
import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public class FriendsScreen {

  public static void configure(FriendsContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    FriendsState state = mediator.getFriendsState();
    RepositoryContract repository = Repository.getInstance(context.get());

    FriendsContract.Router router = new FriendsRouter(mediator);
    FriendsContract.Presenter presenter = new FriendsPresenter(state);
    FriendsContract.Model model = new FriendsModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
