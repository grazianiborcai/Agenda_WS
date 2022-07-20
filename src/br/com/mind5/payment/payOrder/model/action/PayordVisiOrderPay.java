package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderCopier;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.decisionTree.OrderRootPay;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordVisiOrderPay extends ActionVisitorTemplateAction<PayordInfo, OrderInfo> {
	
	public PayordVisiOrderPay(DeciTreeOption<PayordInfo> option) {
		super(option, PayordInfo.class, OrderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderInfo>> getTreeClassHook() {
		return OrderRootPay.class;
	}
	
	
	
	@Override protected List<OrderInfo> toActionClassHook(List<PayordInfo> recordInfos) {
		return OrderCopier.copyFromPayord(recordInfos);
	}
	
	
	
	@Override protected List<PayordInfo> toBaseClassHook(List<PayordInfo> baseInfos, List<OrderInfo> results) {
		return baseInfos;
	}
}
