package action;

import Controller.Action;
import Model.ViceCoordenador;
import Persistence.ViceCoordenadorDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GravarViceCoordenadorAction implements Action{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ViceCoordenador viceCoordenador = new ViceCoordenador(
                Float.parseFloat(request.getParameter("txtSalarioBase")),
                Integer.parseInt(request.getParameter("txtTempoServico")),
                request.getParameter("txtNomePessoa"),
                Integer.parseInt(request.getParameter("txtIdadePessoa"))
        );

        try {

            ViceCoordenadorDAO.getInstancia().save(viceCoordenador);
            response.sendRedirect("FrontController?action=LerViceCoordenador");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
