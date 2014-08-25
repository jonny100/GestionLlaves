package bbp;

import entity.Aulas;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "aulasController")
@ViewScoped
public class AulasController extends AbstractController<Aulas> {

    @Inject
    private PrestamoController prestamoCollectionController;

    public AulasController() {
        // Inform the Abstract parent controller of the concrete Aulas?cap_first Entity
        super(Aulas.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Prestamo entities that
     * are retrieved from Aulas?cap_first and returns the navigation outcome.
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
