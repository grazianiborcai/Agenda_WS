package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.decisionTree.PayordRootRefresh;

public final class OrderVisiPayordRefresh extends ActionVisitorTemplateAction<OrderInfo, PayordInfo> {
	
	public OrderVisiPayordRefresh(DeciTreeOption<OrderInfo> option) {
		super(option, OrderInfo.class, PayordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordInfo>> getTreeClassHook() {
		return PayordRootRefresh.class;
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<PayordInfo> results) {
		return baseInfos;
	}
}
