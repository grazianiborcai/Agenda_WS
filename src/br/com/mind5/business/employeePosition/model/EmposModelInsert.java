package br.com.mind5.business.employeePosition.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.decisionTree.RootEmposInsert;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposModelInsert extends ModelTemplate<EmposInfo> {

	public EmposModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, EmposInfo.class);
	}
	
	
	
	@Override protected DeciTree<EmposInfo> getDecisionTreeHook(DeciTreeOption<EmposInfo> option) {
		return new RootEmposInsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
