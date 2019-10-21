package es.ulpgc.dayron.spotifly.forgotPassword;

import android.util.Log;
import android.widget.EditText;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.spotifly.app.RepositoryContract;


public class ForgotPasswordPresenter implements ForgotPasswordContract.Presenter {

  public static String TAG = ForgotPasswordPresenter.class.getSimpleName();

  private WeakReference<ForgotPasswordContract.View> view;
  private ForgotPasswordViewModel viewModel;
  private ForgotPasswordContract.Model model;
  private ForgotPasswordContract.Router router;

  public ForgotPasswordPresenter(ForgotPasswordState state) {
    viewModel = state;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // use passed state if is necessary
    ForgotPasswordState state = router.getDataFromPreviousScreen();
    if (state != null) {

      // update view and model state
      viewModel.data = state.data;

      // update the view
      view.get().displayData(viewModel);

      return;
    }

    // call the model
    String data = model.fetchData();

    // set view state
    viewModel.data = data;

    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void forgotPassword(String email) {
    model.forgotPassword(email, new RepositoryContract.ForgotPassword() {
      @Override
      public void onForgotPassword(boolean error) {
        if(error==false){
          view.get().displaySuccess();
          router.goLogin();
        }else{
          view.get().displayError();
        }
      }
    });
  }



  @Override
  public void injectView(WeakReference<ForgotPasswordContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ForgotPasswordContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ForgotPasswordContract.Router router) {
    this.router = router;
  }
}
