package action;

import Controller.Action;
import Model.ViceCoordenador;
import Persistence.ViceCoordenadorDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarViceCoordenadorAction implements Action {

    public EditarViceCoordenadorAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ViceCoordenador viceCoordenador = new ViceCoordenador(
                Float.parseFloat(request.getParameter("txtSalarioBase")),
                Integer.parseInt(request.getParameter("txtTempoServico")),
                Integer.parseInt(request.getParameter("txtIdCoordenador")),
                request.getParameter("txtNomePessoa"),
                Integer.parseInt(request.getParameter("txtIdadePessoa"))
        );

        try {

            ViceCoordenadorDAO.getInstancia().editar(viceCoordenador);
            response.sendRedirect("FrontController?action=LerCoordenador");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
