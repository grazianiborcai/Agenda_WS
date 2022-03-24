package br.com.mind5.payment.payOrderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.decisionTree.OrderemRootRefresh;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class VisiPayordemOrderemRefresh extends ActionVisitorTemplateAction<PayordemInfo, OrderemInfo> {
	
	public VisiPayordemOrderemRefresh(DeciTreeOption<PayordemInfo> option) {
		super(option, PayordemInfo.class, OrderemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderemInfo>> getTreeClassHook() {
		return OrderemRootRefresh.class;
	}
	
	
	
	@Override protected List<PayordemInfo> toBaseClassHook(List<PayordemInfo> baseInfos, List<OrderemInfo> results) {
		return baseInfos;
	}
}
