package WatcherPatter;

/**具体观察者角色（订阅者）
 * Created by xkc on 3/15/16.
 */
public class ConcreteWatcher implements Watcher {
    @Override
    public void update(String str) {
        System.out.println(str);
    }
}
