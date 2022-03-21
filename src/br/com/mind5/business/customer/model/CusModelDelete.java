package br.com.mind5.business.customer.model;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.decisionTree.CusRootDelete;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusModelDelete extends ModelTemplate<CusInfo> {

	public CusModelDelete(CusInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CusInfo> getDecisionTreeHook(DeciTreeOption<CusInfo> option) {
		return new CusRootDelete(option);
	}
}
