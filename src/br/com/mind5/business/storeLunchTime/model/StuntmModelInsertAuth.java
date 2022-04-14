package br.com.mind5.business.storeLunchTime.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.decisionTree.StuntmRootInsertAuth;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmModelInsertAuth extends ModelTemplate<StuntmInfo> {

	public StuntmModelInsertAuth(String incomingData, HttpServletRequest request) {
		super(incomingData, request, StuntmInfo.class);
	}
	
	
	
	@Override protected DeciTree<StuntmInfo> getDecisionTreeHook(DeciTreeOption<StuntmInfo> option) {
		return new StuntmRootInsertAuth(option);
	}
}
