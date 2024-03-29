package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.decisionTree.OrderRootRefreshPayord;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordVisiOrderRefresh extends ActionVisitorTemplateAction<PayordInfo, OrderInfo> {
	
	public PayordVisiOrderRefresh(DeciTreeOption<PayordInfo> option) {
		super(option, PayordInfo.class, OrderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderInfo>> getTreeClassHook() {
		return OrderRootRefreshPayord.class;
	}
	
	
	
	@Override protected List<PayordInfo> toBaseClassHook(List<PayordInfo> baseInfos, List<OrderInfo> results) {
		return baseInfos;
	}
}
