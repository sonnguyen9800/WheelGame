package controller;

import model.GameEngineImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SpinPanelController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("LOL");
        GameEngineImpl gameEngine = (GameEngineImpl) GameEngineImpl.getSingletonInstance();
        gameEngine.spin(500,2000,200);

    }
}
