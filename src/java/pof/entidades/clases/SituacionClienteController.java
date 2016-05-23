package pof.entidades.clases;

import pof.entidades.SituacionCliente;
import pof.entidades.clases.util.JsfUtil;
import pof.entidades.clases.util.PaginationHelper;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("situacionClienteController")
@SessionScoped
public class SituacionClienteController implements Serializable {

    private SituacionCliente current;
    private DataModel items = null;
    @EJB
    private pof.entidades.clases.SituacionClienteFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public SituacionClienteController() {
    }

    public SituacionCliente getSelected() {
        if (current == null) {
            current = new SituacionCliente();
            current.setSituacionClientePK(new pof.entidades.SituacionClientePK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private SituacionClienteFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (SituacionCliente) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new SituacionCliente();
        current.setSituacionClientePK(new pof.entidades.SituacionClientePK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getSituacionClientePK().setNumpropiedad(current.getPropiedad().getNumpropiedad());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("SituacionClienteCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (SituacionCliente) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getSituacionClientePK().setNumpropiedad(current.getPropiedad().getNumpropiedad());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("SituacionClienteUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (SituacionCliente) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("SituacionClienteDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public SituacionCliente getSituacionCliente(pof.entidades.SituacionClientePK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = SituacionCliente.class)
    public static class SituacionClienteControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SituacionClienteController controller = (SituacionClienteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "situacionClienteController");
            return controller.getSituacionCliente(getKey(value));
        }

        pof.entidades.SituacionClientePK getKey(String value) {
            pof.entidades.SituacionClientePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new pof.entidades.SituacionClientePK();
            key.setCodsituacion(values[0]);
            key.setNumpropiedad(values[1]);
            return key;
        }

        String getStringKey(pof.entidades.SituacionClientePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodsituacion());
            sb.append(SEPARATOR);
            sb.append(value.getNumpropiedad());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SituacionCliente) {
                SituacionCliente o = (SituacionCliente) object;
                return getStringKey(o.getSituacionClientePK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + SituacionCliente.class.getName());
            }
        }

    }

}
