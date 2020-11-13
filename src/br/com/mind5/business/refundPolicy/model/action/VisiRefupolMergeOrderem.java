package br.com.mind5.business.refundPolicy.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.decisionTree.RootOrderemSelect;
import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.business.refundPolicy.info.RefupolMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefupolMergeOrderem extends ActionVisitorTemplateMerge<RefupolInfo, OrderemInfo> {
	
	public VisiRefupolMergeOrderem(DeciTreeOption<RefupolInfo> option) {
		super(option, OrderemInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderemInfo>> getTreeClassHook() {
		return RootOrderemSelect.class;
	}
	
	
	
	@Override protected List<RefupolInfo> mergeHook(List<RefupolInfo> baseInfos, List<OrderemInfo> selectedInfos) {	
		return RefupolMerger.mergeWithOrderem(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
