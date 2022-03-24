package br.com.mind5.business.storeWorkTime.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.decisionTree.StowotmRootUpdate;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmModelUpdate extends ModelTemplate<StowotmInfo> {

	public StowotmModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, StowotmInfo.class);
	}
	
	
	
	@Override protected DeciTree<StowotmInfo> getDecisionTreeHook(DeciTreeOption<StowotmInfo> option) {
		return new StowotmRootUpdate(option);
	}
}
