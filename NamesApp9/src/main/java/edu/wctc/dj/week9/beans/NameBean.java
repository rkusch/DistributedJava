/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week9.beans;
import edu.wctc.dj.week9.model.Name;
import edu.wctc.dj.week9.model.NameService;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author ryan
 */
@Named(value = "nameBean")
@SessionScoped
public class NameBean implements Serializable {

    private final NameService nameService = new NameService();
    private Name name;
    private List<Name> nameList;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Name> getNameList() {
        return nameList;
    }

    public void setNameList(List<Name> nameList) {
        this.nameList = nameList;
    }

    public String allNames() {
        nameList = nameService.getAllNames();
        return "nameList";
    }

    public void nameDetail(AjaxBehaviorEvent event) {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("nameDetail.xhtml?id=" + name.getId());
        } catch (IOException ex) {
            FacesMessage msg = new FacesMessage("IOException", name.getId());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    /**
     * Creates a new instance of NameBean
     */
    public NameBean() {
    }

}
