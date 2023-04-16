package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrder.model.decisionTree.RefuRootRefund;

public final class OrderVisiRefuRefund extends ActionVisitorTemplateAction<OrderInfo, RefuInfo> {
	
	public OrderVisiRefuRefund(DeciTreeOption<OrderInfo> option) {
		super(option, OrderInfo.class, RefuInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefuInfo>> getTreeClassHook() {
		return RefuRootRefund.class;
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<RefuInfo> results) {
		return baseInfos;
	}
}
