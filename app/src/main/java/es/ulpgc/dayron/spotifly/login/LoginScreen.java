package es.ulpgc.dayron.spotifly.login;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;
import es.ulpgc.dayron.spotifly.app.AppMediator;
import es.ulpgc.dayron.spotifly.app.Repository;
import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public class LoginScreen {

  public static void configure(LoginContract.View view) {
    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    LoginState state = mediator.getLoginState();
    RepositoryContract repository = Repository.getInstance(context.get());

    LoginContract.Router router = new LoginRouter(mediator);
    LoginContract.Presenter presenter = new LoginPresenter(state);
    LoginContract.Model model = new LoginModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
