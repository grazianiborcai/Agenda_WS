package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.decisionTree.OrderNodeUpdate;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderVisiNodeUpdate extends ActionVisitorTemplateAction<OrderInfo, OrderInfo> {

	public OrderVisiNodeUpdate(DeciTreeOption<OrderInfo> option) {
		super(option, OrderInfo.class, OrderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderInfo>> getTreeClassHook() {
		return OrderNodeUpdate.class;
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<OrderInfo> results) {
		return results;
	}
}
