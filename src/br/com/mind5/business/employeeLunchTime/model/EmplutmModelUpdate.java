package br.com.mind5.business.employeeLunchTime.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.decisionTree.EmplutmRootUpdate;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmModelUpdate extends ModelTemplate<EmplutmInfo> {

	public EmplutmModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, EmplutmInfo.class);
	}
	
	
	
	@Override protected DeciTree<EmplutmInfo> getDecisionTreeHook(DeciTreeOption<EmplutmInfo> option) {
		return new EmplutmRootUpdate(option);
	}
}
