package br.com.mind5.business.employeePosition.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.decisionTree.RootEmposInsertProfessional;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposModelInsertProfessional extends ModelTemplate<EmposInfo> {

	public EmposModelInsertProfessional(String incomingData, HttpServletRequest request) {
		super(incomingData, request, EmposInfo.class);
	}
	
	
	
	@Override protected DeciTree<EmposInfo> getDecisionTreeHook(DeciTreeOption<EmposInfo> option) {
		return new RootEmposInsertProfessional(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
