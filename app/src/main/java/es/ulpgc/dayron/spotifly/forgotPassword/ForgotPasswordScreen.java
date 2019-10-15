package es.ulpgc.dayron.spotifly.forgotPassword;

import java.lang.ref.WeakReference;
import androidx.fragment.app.FragmentActivity;
import es.ulpgc.dayron.spotifly.app.AppMediator;

public class ForgotPasswordScreen {

  public static void configure(ForgotPasswordContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    ForgotPasswordState state = mediator.getForgotPasswordState();

    ForgotPasswordContract.Router router = new ForgotPasswordRouter(mediator);
    ForgotPasswordContract.Presenter presenter = new ForgotPasswordPresenter(state);
    ForgotPasswordContract.Model model = new ForgotPasswordModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
