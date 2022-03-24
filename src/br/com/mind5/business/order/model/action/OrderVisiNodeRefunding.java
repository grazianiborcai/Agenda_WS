package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.decisionTree.OrderNodeRefunding;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderVisiNodeRefunding extends ActionVisitorTemplateAction<OrderInfo, OrderInfo> {

	public OrderVisiNodeRefunding(DeciTreeOption<OrderInfo> option) {
		super(option, OrderInfo.class, OrderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderInfo>> getTreeClassHook() {
		return OrderNodeRefunding.class;
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<OrderInfo> results) {
		return results;
	}
}
