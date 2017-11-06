package WatcherPatter;

/**抽象主题角色，即抽象被观察者watched
 * Created by xkc on 3/15/16.
 */
public interface Watched {
    public void addWatcher(Watcher watcher);
    public void removeWatcher(Watcher watcher);
    public void notifyWatchers(String str);
}
