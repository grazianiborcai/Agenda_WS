package br.com.mind5.payment.payOrderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.decisionTree.RootOrderemPay;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class VisiPayordemOrderemPay extends ActionVisitorTemplateActionV2<PayordemInfo, OrderemInfo> {
	
	public VisiPayordemOrderemPay(DeciTreeOption<PayordemInfo> option) {
		super(option, PayordemInfo.class, OrderemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderemInfo>> getTreeClassHook() {
		return RootOrderemPay.class;
	}
	
	
	
	@Override protected List<PayordemInfo> toBaseClassHook(List<PayordemInfo> baseInfos, List<OrderemInfo> results) {
		return baseInfos;
	}
}