package action;

import Controller.Action;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AlgumaCoisaTesteAction implements Action, Observer{
    
    private Observable instanciaEdita;
    
    AlgumaCoisaTesteAction(Observable instanciaEdita){
        this.instanciaEdita = instanciaEdita;
        instanciaEdita.addObserver(this);
    }

    public void setInstanciaEdita(Observable instanciaEdita) {
        this.instanciaEdita = instanciaEdita;
        instanciaEdita.addObserver(this);
    }
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
    }

    @Override
    public void update(Observable o, Object arg) {
        
        System.out.println("CAAAAAAAAAAAAAAAAARALHO PORRA FUNCIONOU OBSERVER FULL TRAB");
        
    }
    
}
