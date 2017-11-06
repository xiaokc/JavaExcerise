package designmode.observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by xkc on 8/21/16.
 */
public class Test {
    JFrame jFrame;
    public static void main(String[] args){
//        ConcreteSubject subject = new ConcreteSubject();
//
//        ConcreteObserver observer1 = new ConcreteObserver(subject);
//        ConcreteObserver observer2 = new ConcreteObserver(subject);
//
//        observer1.subscribe();
//        observer2.subscribe();
//
//        subject.notifyObservers("hello");
//
//        observer1.cancelSubscribe();
//        subject.notifyObservers("happy");
        Test test = new Test();
        test.go();

    }

    public void go(){
        jFrame = new JFrame();
        JButton button = new JButton("Should I do it?");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
        jFrame.getContentPane().add(BorderLayout.CENTER,button);
    }


    class AngelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Don't do it, you might regret it!");
        }
    }

    class DevilListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Come on, do it!");
        }
    }
}
