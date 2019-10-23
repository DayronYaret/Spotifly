package es.ulpgc.dayron.spotifly.addSongs;

import java.lang.ref.WeakReference;
import androidx.fragment.app.FragmentActivity;
import es.ulpgc.dayron.spotifly.app.AppMediator;
import es.ulpgc.dayron.spotifly.app.Repository;
import es.ulpgc.dayron.spotifly.app.RepositoryContract;

public class AddSongsScreen {

  public static void configure(AddSongsContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    AddSongsState state = mediator.getAddSongsState();
    RepositoryContract repository = Repository.getInstance(context.get());

    AddSongsContract.Router router = new AddSongsRouter(mediator);
    AddSongsContract.Presenter presenter = new AddSongsPresenter(state);
    AddSongsContract.Model model = new AddSongsModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
