package bbp;

import bbp.util.JsfUtil;
import entity.Prestamo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ejb.EJB;
import sbp.PrestamoFacade;

@Named(value = "prestamoController")
@ViewScoped
public class PrestamoController extends AbstractController<Prestamo> {

    @Inject
    private AulasController idAulasController;
    @Inject
    private MotivoController idmotivoController;
    @EJB
    private sbp.PrestamoFacade ejbFacade;
    private List<Prestamo> lst_p_f = new ArrayList();
    private Date fecha1;

    public AulasController getIdAulasController() {
        return idAulasController;
    }

    public void setIdAulasController(AulasController idAulasController) {
        this.idAulasController = idAulasController;
    }

    public MotivoController getIdmotivoController() {
        return idmotivoController;
    }

    public void setIdmotivoController(MotivoController idmotivoController) {
        this.idmotivoController = idmotivoController;
    }

    public PrestamoFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(PrestamoFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public List<Prestamo> getLst_p_f() {
        return lst_p_f;
    }

    public void setLst_p_f(List<Prestamo> lst_p_f) {
        this.lst_p_f = lst_p_f;
    }

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }
    

    public PrestamoController() {
        // Inform the Abstract parent controller of the concrete Prestamo?cap_first Entity
        super(Prestamo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idAulasController.setSelected(null);
        idmotivoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Aulas controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdAulas(ActionEvent event) {
        if (this.getSelected() != null && idAulasController.getSelected() == null) {
            idAulasController.setSelected(this.getSelected().getIdAulas());
        }
    }

    /**
     * Sets the "selected" attribute of the Motivo controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdmotivo(ActionEvent event) {
        if (this.getSelected() != null && idmotivoController.getSelected() == null) {
            idmotivoController.setSelected(this.getSelected().getIdmotivo());
        }
    }
    
    public void devuelto(){
        Date hora = new Date();
        getSelected().setQuienDevuelve(getSelected().getQuienRetira());
        getSelected().setHorarioDevuelto(hora);
        save(null);
    }
    
    public void obtener_prestamo_por_fecha() {
        lst_p_f = ejbFacade.turnos_por_fecha(fecha1);
    }
}
