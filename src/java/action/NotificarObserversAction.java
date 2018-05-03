/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import Model.Prova;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotificarObserversAction implements Action, Observer{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
    }

    @Override
    public void update(Observable provaSubject, Object arg) {
        if ( provaSubject instanceof Prova) {
            Prova prova = (Prova) provaSubject;
                        

        }
    }
    
}
