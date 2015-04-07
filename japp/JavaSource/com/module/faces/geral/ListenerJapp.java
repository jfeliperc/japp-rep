package com.module.faces.geral;

import javax.ejb.EJB;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

import com.module.ejb.contract.IPessoaEjb;

/**
 * Application Lifecycle Listener implementation class ListenerJapp
 *
 */
@WebListener
public class ListenerJapp implements PhaseListener {

	private static final long serialVersionUID = 4199326208038237016L;

	@EJB
	private IPessoaEjb pessoaEjb;
	
	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
        ExternalContext ext = context.getExternalContext();
        HttpSession session = (HttpSession) ext.getSession(false);
        boolean newSession = (session == null) || (session.isNew());
        //boolean postback = !ext.getRequestParameterMap().isEmpty(); // Depois de logado, este objeto sempre vem false (era pra vir true)
        boolean timedout = newSession; //postback && newSession;
        
//        if (session != null){
//            String chave = (String)session.getAttribute("AUTHENTICATED");
//            timedout = ((chave == null)||("".equals(chave)));
//        }
//        
//        if (timedout) {
//            //if (pessoaEjb.buscarQtdPessoa() > 0){        	
//        	if ((!context.getViewRoot().getViewId().contains("login.xhtml"))
//        		&&
//        		(!context.getViewRoot().getViewId().contains("cadLogin.xhtml"))){
//                NavigationHandler nh = context.getApplication().getNavigationHandler();
//                nh.handleNavigation(context, null, "login");
//            }
//            //}
//        }
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		
	}

	@Override
	public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
	}

    	
}
