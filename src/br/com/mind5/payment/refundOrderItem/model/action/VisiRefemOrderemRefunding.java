package br.com.mind5.payment.refundOrderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.decisionTree.RootOrderemRefunding;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

final class VisiRefemOrderemRefunding extends ActionVisitorTemplateAction<RefemInfo, OrderemInfo> {
	
	public VisiRefemOrderemRefunding(DeciTreeOption<RefemInfo> option) {
		super(option, RefemInfo.class, OrderemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderemInfo>> getTreeClassHook() {
		return RootOrderemRefunding.class;
	}
	
	
	
	@Override protected List<RefemInfo> toBaseClassHook(List<RefemInfo> baseInfos, List<OrderemInfo> results) {	
		return baseInfos;
	}
}
