package action;

import Controller.Action;
import Model.Coordenador;
import Model.ViceCoordenador;
import Persistence.CoordenadorDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarCoordenadorAction implements Action {

    public EditarCoordenadorAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Coordenador coordenador = new Coordenador(
                new ViceCoordenador(Integer.parseInt(request.getParameter("txtIdViceCoordenador"))),
                Float.parseFloat(request.getParameter("txtSalarioBase")),
                Integer.parseInt(request.getParameter("txtTempoServico")),
                Integer.parseInt(request.getParameter("txtIdCoordenador")),
                request.getParameter("txtNomeCoordenador"),
                Integer.parseInt(request.getParameter("txtIdadeCoordenador"))
        );

        try {

            CoordenadorDAO.getInstancia().editar(coordenador);
            response.sendRedirect("FrontController?action=LerCoordenador");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
