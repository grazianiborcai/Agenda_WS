package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemMerger;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.model.decisionTree.RootRefugroupSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderemMergeRefugroup extends ActionVisitorTemplateMerge<OrderemInfo, RefugroupInfo> {
	
	public VisiOrderemMergeRefugroup(DeciTreeOption<OrderemInfo> option) {
		super(option, RefugroupInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefugroupInfo>> getTreeClassHook() {
		return RootRefugroupSelect.class;
	}
	
	
	
	@Override protected List<OrderemInfo> mergeHook(List<OrderemInfo> baseInfos, List<RefugroupInfo> selectedInfos) {	
		return OrderemMerger.mergeWithRefugroup(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
