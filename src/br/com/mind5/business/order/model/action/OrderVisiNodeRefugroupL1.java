package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.decisionTree.OrderNodeRefugroupL1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderVisiNodeRefugroupL1 extends ActionVisitorTemplateAction<OrderInfo, OrderInfo> {

	public OrderVisiNodeRefugroupL1(DeciTreeOption<OrderInfo> option) {
		super(option, OrderInfo.class, OrderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderInfo>> getTreeClassHook() {
		return OrderNodeRefugroupL1.class;
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<OrderInfo> results) {
		return results;
	}
}
