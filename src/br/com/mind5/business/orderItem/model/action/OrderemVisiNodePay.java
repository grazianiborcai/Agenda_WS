package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.decisionTree.OrderemNodePay;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderemVisiNodePay extends ActionVisitorTemplateAction<OrderemInfo, OrderemInfo> {

	public OrderemVisiNodePay(DeciTreeOption<OrderemInfo> option) {
		super(option, OrderemInfo.class, OrderemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderemInfo>> getTreeClassHook() {
		return OrderemNodePay.class;
	}
	
	
	
	@Override protected List<OrderemInfo> toBaseClassHook(List<OrderemInfo> baseInfos, List<OrderemInfo> results) {
		return results;
	}
}
