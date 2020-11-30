package br.com.mind5.business.employeeList.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.decisionTree.RootEmplisSearchAuth;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplisModelSearchAuth extends ModelTemplate<EmplisInfo> {

	public EmplisModelSearchAuth(String incomingData, HttpServletRequest request) {
		super(incomingData, request, EmplisInfo.class);
	}
	
	
	
	@Override protected DeciTree<EmplisInfo> getDecisionTreeHook(DeciTreeOption<EmplisInfo> option) {
		return new RootEmplisSearchAuth(option);
	}
}
