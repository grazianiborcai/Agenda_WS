package br.com.mind5.business.storeLeaveDate.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.decisionTree.StolateRootUpdate;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolateModelUpdate extends ModelTemplate<StolateInfo> {

	public StolateModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, StolateInfo.class);
	}
	
	
	
	@Override protected DeciTree<StolateInfo> getDecisionTreeHook(DeciTreeOption<StolateInfo> option) {
		return new StolateRootUpdate(option);
	}
}
