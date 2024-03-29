package br.com.mind5.payment.payOrderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.decisionTree.OrderemRootPay;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemVisiOrderemPay extends ActionVisitorTemplateAction<PayordemInfo, OrderemInfo> {
	
	public PayordemVisiOrderemPay(DeciTreeOption<PayordemInfo> option) {
		super(option, PayordemInfo.class, OrderemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderemInfo>> getTreeClassHook() {
		return OrderemRootPay.class;
	}
	
	
	
	@Override protected List<PayordemInfo> toBaseClassHook(List<PayordemInfo> baseInfos, List<OrderemInfo> results) {
		return baseInfos;
	}
}
