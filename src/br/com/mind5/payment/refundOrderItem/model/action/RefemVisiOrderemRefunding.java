package br.com.mind5.payment.refundOrderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.decisionTree.OrderemRootRefunding;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class RefemVisiOrderemRefunding extends ActionVisitorTemplateAction<RefemInfo, OrderemInfo> {
	
	public RefemVisiOrderemRefunding(DeciTreeOption<RefemInfo> option) {
		super(option, RefemInfo.class, OrderemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderemInfo>> getTreeClassHook() {
		return OrderemRootRefunding.class;
	}
	
	
	
	@Override protected List<RefemInfo> toBaseClassHook(List<RefemInfo> baseInfos, List<OrderemInfo> results) {	
		return baseInfos;
	}
}
