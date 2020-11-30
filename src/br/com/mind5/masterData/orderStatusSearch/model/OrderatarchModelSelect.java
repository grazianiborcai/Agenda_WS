package br.com.mind5.masterData.orderStatusSearch.model;

import br.com.mind5.masterData.orderStatusSearch.info.OrderatarchInfo;
import br.com.mind5.masterData.orderStatusSearch.model.decisionTree.RootOrderatarchSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderatarchModelSelect extends ModelTemplate<OrderatarchInfo> {

	public OrderatarchModelSelect(OrderatarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<OrderatarchInfo> getDecisionTreeHook(DeciTreeOption<OrderatarchInfo> option) {
		return new RootOrderatarchSelect(option);
	}
}
