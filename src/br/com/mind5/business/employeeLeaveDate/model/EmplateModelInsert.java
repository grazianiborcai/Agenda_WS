package br.com.mind5.business.employeeLeaveDate.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.decisionTree.RootEmplateInsert;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplateModelInsert extends ModelTemplate<EmplateInfo> {

	public EmplateModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, EmplateInfo.class);
	}
	
	
	
	@Override protected DeciTree<EmplateInfo> getDecisionTreeHook(DeciTreeOption<EmplateInfo> option) {
		return new RootEmplateInsert(option);
	}
}
