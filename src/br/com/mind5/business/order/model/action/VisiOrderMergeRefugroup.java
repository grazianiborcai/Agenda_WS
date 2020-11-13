package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.model.decisionTree.RootRefugroupSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderMergeRefugroup extends ActionVisitorTemplateMerge<OrderInfo, RefugroupInfo> {
	
	public VisiOrderMergeRefugroup(DeciTreeOption<OrderInfo> option) {
		super(option, RefugroupInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefugroupInfo>> getTreeClassHook() {
		return RootRefugroupSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> baseInfos, List<RefugroupInfo> selectedInfos) {	
		return OrderMerger.mergeWithRefugroup(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
