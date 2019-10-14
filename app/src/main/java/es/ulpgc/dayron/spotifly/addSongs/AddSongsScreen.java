package es.ulpgc.dayron.spotifly.addSongs;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class AddSongsScreen {

  public static void configure(AddSongsContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AddSongsState state = mediator.getAddSongsState();

    AddSongsContract.Router router = new AddSongsRouter(mediator);
    AddSongsContract.Presenter presenter = new AddSongsPresenter(state);
    AddSongsContract.Model model = new AddSongsModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
