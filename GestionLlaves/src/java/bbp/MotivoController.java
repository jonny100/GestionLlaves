package bbp;

import entity.Motivo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "motivoController")
@ViewScoped
public class MotivoController extends AbstractController<Motivo> {

    @Inject
    private PrestamoController prestamoCollectionController;

    public MotivoController() {
        // Inform the Abstract parent controller of the concrete Motivo?cap_first Entity
        super(Motivo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Prestamo entities that
     * are retrieved from Motivo?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Prestamo page
     */
    public String navigatePrestamoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Prestamo_items", this.getSelected().getPrestamoCollection());
        }
        return "/prestamo/index";
    }

}
