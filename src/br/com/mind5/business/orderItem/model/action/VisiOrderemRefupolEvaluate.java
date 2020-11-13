package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.business.refundPolicy.model.decisionTree.RootRefupolEvaluate;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderemRefupolEvaluate extends ActionVisitorTemplateAction<OrderemInfo, RefupolInfo> {
	
	public VisiOrderemRefupolEvaluate(DeciTreeOption<OrderemInfo> option) {
		super(option, OrderemInfo.class, RefupolInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefupolInfo>> getTreeClassHook() {
		return RootRefupolEvaluate.class;
	}
	
	
	
	@Override protected List<OrderemInfo> toBaseClassHook(List<OrderemInfo> baseInfos, List<RefupolInfo> results) {
		return baseInfos;
	}
}
