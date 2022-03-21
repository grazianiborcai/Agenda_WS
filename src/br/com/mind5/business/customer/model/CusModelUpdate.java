package br.com.mind5.business.customer.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.decisionTree.CusRootUpdate;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusModelUpdate extends ModelTemplate<CusInfo> {

	public CusModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, CusInfo.class);
	}
	
	
	
	@Override protected DeciTree<CusInfo> getDecisionTreeHook(DeciTreeOption<CusInfo> option) {
		return new CusRootUpdate(option);
	}
}
