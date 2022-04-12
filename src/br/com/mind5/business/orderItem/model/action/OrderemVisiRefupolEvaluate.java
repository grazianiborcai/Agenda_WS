package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.business.refundPolicy.model.decisionTree.RefupolRootEvaluate;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderemVisiRefupolEvaluate extends ActionVisitorTemplateAction<OrderemInfo, RefupolInfo> {
	
	public OrderemVisiRefupolEvaluate(DeciTreeOption<OrderemInfo> option) {
		super(option, OrderemInfo.class, RefupolInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefupolInfo>> getTreeClassHook() {
		return RefupolRootEvaluate.class;
	}
	
	
	
	@Override protected List<OrderemInfo> toBaseClassHook(List<OrderemInfo> baseInfos, List<RefupolInfo> results) {
		return baseInfos;
	}
}
