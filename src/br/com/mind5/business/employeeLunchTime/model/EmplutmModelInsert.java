package br.com.mind5.business.employeeLunchTime.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.decisionTree.EmplutmRootInsert;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmModelInsert extends ModelTemplate<EmplutmInfo> {

	public EmplutmModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, EmplutmInfo.class);
	}
	
	
	
	@Override protected DeciTree<EmplutmInfo> getDecisionTreeHook(DeciTreeOption<EmplutmInfo> option) {
		return new EmplutmRootInsert(option);
	}
}
