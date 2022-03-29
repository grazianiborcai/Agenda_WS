package br.com.mind5.business.orderHistory.model.action;

import java.util.List;

import br.com.mind5.business.orderHistory.info.OrdoryInfo;
import br.com.mind5.business.orderHistory.info.OrdoryMerger;
import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.decisionTree.OrdistRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdoryMergeOrdistSearch extends ActionVisitorTemplateMerge<OrdoryInfo, OrdistInfo> {
	
	public VisiOrdoryMergeOrdistSearch(DeciTreeOption<OrdoryInfo> option) {
		super(option, OrdistInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdistInfo>> getTreeClassHook() {
		return OrdistRootSearch.class;
	}
	
	
	
	@Override protected List<OrdoryInfo> mergeHook(List<OrdoryInfo> baseInfos, List<OrdistInfo> selectedInfos) {	
		return OrdoryMerger.mergeWithOrdist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
