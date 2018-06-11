package im.shimo.react.x5.webview;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.tencent.smtt.sdk.WebView;


public class RNX5WebViewPackage implements ReactPackage {
    private class X5WebViewModule extends ReactContextBaseJavaModule {

        private ReactApplicationContext mReactContext;

        public X5WebViewModule(ReactApplicationContext reactContext) {
            super(reactContext);
            mReactContext = reactContext;
        }

        @Override
        public String getName() {
            return "X5WebView";
        }

        @ReactMethod
        public void getX5CoreVersion(Callback callback) {
            callback.invoke(WebView.getTbsCoreVersion(mReactContext));
        }
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new X5WebViewModule(reactContext));
        return modules;
    }

    // @Override
    // public List<Class<? extends JavaScriptModule>> createJSModules() {
    //     return Collections.emptyList();
    // }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        List<ViewManager> modules = new ArrayList<>();
        modules.add(new RNX5WebViewManager(reactContext));
        return modules;
    }
}
