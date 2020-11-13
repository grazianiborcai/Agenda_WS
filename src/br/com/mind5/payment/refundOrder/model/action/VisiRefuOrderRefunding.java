package br.com.mind5.payment.refundOrder.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderCopier;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.decisionTree.RootOrderRefunding;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

final class VisiRefuOrderRefunding extends ActionVisitorTemplateAction<RefuInfo, OrderInfo> {
	
	public VisiRefuOrderRefunding(DeciTreeOption<RefuInfo> option) {
		super(option, RefuInfo.class, OrderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderInfo>> getTreeClassHook() {
		return RootOrderRefunding.class;
	}
	
	
	
	protected List<OrderInfo> toActionClassHook(List<RefuInfo> recordInfos) {
		return OrderCopier.copyFromRefu(recordInfos);
	}
	
	
	
	@Override protected List<RefuInfo> toBaseClassHook(List<RefuInfo> baseInfos, List<OrderInfo> results) {	
		return baseInfos;
	}
}
