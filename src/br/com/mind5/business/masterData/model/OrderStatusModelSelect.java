package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootOrderStatusSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderStatusModelSelect extends ModelTemplate<OrderStatusInfo> {

	public OrderStatusModelSelect(OrderStatusInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<OrderStatusInfo> getDecisionTreeHook(DeciTreeOption<OrderStatusInfo> option) {
		return new RootOrderStatusSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
