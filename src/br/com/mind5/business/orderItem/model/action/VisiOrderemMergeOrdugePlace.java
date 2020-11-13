package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemMerger;
import br.com.mind5.business.orderStatusChange.info.OrdugeCopier;
import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.business.orderStatusChange.model.decisionTree.RootOrdugePlace;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderemMergeOrdugePlace extends ActionVisitorTemplateMerge<OrderemInfo, OrdugeInfo> {
	
	public VisiOrderemMergeOrdugePlace(DeciTreeOption<OrderemInfo> option) { 
		super(option, OrdugeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdugeInfo>> getTreeClassHook() {
		return RootOrdugePlace.class;
	}
	
	
	
	@Override protected List<OrdugeInfo> toActionClassHook(List<OrderemInfo> baseInfos) {
		return OrdugeCopier.copyFromOrderem(baseInfos);
	}
	
	
	
	@Override protected List<OrderemInfo> mergeHook(List<OrderemInfo> baseInfos, List<OrdugeInfo> selectedInfos) {	
		return OrderemMerger.mergeWithOrduge(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
