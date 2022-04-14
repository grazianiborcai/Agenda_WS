package br.com.mind5.business.storeLunchTime.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.decisionTree.StuntmRootUpdate;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmModelUpdate extends ModelTemplate<StuntmInfo> {

	public StuntmModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, StuntmInfo.class);
	}
	
	
	
	@Override protected DeciTree<StuntmInfo> getDecisionTreeHook(DeciTreeOption<StuntmInfo> option) {
		return new StuntmRootUpdate(option);
	}
}
