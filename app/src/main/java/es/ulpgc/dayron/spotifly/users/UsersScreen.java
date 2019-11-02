package es.ulpgc.dayron.spotifly.users;

import java.lang.ref.WeakReference;


import androidx.fragment.app.FragmentActivity;
import es.ulpgc.dayron.spotifly.app.AppMediator;
import es.ulpgc.dayron.spotifly.app.Repository;
import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public class UsersScreen {

  public static void configure(UsersContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    UsersState state = mediator.getUsersState();

    RepositoryContract repository= Repository.getInstance(context.get());
    UsersContract.Router router = new UsersRouter(mediator);
    UsersContract.Presenter presenter = new UsersPresenter(state);
    UsersContract.Model model = new UsersModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
