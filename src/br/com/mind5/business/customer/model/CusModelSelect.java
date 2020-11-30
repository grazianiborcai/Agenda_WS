package br.com.mind5.business.customer.model;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.decisionTree.RootCusSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusModelSelect extends ModelTemplate<CusInfo> {

	public CusModelSelect(CusInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CusInfo> getDecisionTreeHook(DeciTreeOption<CusInfo> option) {
		return new RootCusSelect(option);
	}
}
