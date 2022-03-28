package br.com.mind5.business.orderHistory.model.action;

import java.util.List;

import br.com.mind5.business.orderHistory.info.OrdoryInfo;
import br.com.mind5.business.orderHistory.info.OrdoryMerger;
import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.business.orderItemList.model.decisionTree.OrdemistRootSearchByOrder;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdoryMergeOrdemist extends ActionVisitorTemplateMerge<OrdoryInfo, OrdemistInfo> {
	
	public VisiOrdoryMergeOrdemist(DeciTreeOption<OrdoryInfo> option) {
		super(option, OrdemistInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdemistInfo>> getTreeClassHook() {
		return OrdemistRootSearchByOrder.class;
	}
	
	
	
	@Override protected List<OrdoryInfo> mergeHook(List<OrdoryInfo> baseInfos, List<OrdemistInfo> selectedInfos) {	
		return OrdoryMerger.mergeWithOrdemist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
