package br.com.gda.business.order.model;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.decisionTree.RootOrderSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class OrderModelSelect extends ModelTemplate<OrderInfo> {

	public OrderModelSelect(OrderInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<OrderInfo> getDecisionTreeHook(DeciTreeOption<OrderInfo> option) {
		return new RootOrderSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
