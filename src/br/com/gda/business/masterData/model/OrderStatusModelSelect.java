package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.business.masterData.model.decisionTree.RootOrderStatusSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
