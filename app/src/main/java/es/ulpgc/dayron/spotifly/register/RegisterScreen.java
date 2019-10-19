package es.ulpgc.dayron.spotifly.register;

import java.lang.ref.WeakReference;
import androidx.fragment.app.FragmentActivity;
import es.ulpgc.dayron.spotifly.app.AppMediator;
import es.ulpgc.dayron.spotifly.app.Repository;
import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public class RegisterScreen {

  public static void configure(RegisterContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    RegisterState state = mediator.getRegisterState();
    RepositoryContract repository= Repository.getInstance(context.get());

    RegisterContract.Router router = new RegisterRouter(mediator);
    RegisterContract.Presenter presenter = new RegisterPresenter(state);
    RegisterContract.Model model = new RegisterModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
