package WatcherPatter;

/**
 * Created by xkc on 3/15/16.
 */
public class Test {
    public static void main(String[] args){
        ConcreteWatched subject = new ConcreteWatched();//发布者
        ConcreteWatcher watcher1 = new ConcreteWatcher();//订阅者1
        ConcreteWatcher watcher2 = new ConcreteWatcher();//订阅者2

        subject.addWatcher(watcher1);
        subject.addWatcher(watcher2);

        subject.notifyWatchers("发布者向订阅者发布信息~~~");

        subject.removeWatcher(watcher1);

        subject.notifyWatchers("发布者删除订阅者1后发布信息。。。。");




    }
}
