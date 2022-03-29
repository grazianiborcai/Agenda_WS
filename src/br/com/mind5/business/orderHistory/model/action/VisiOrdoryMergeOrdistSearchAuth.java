package br.com.mind5.business.orderHistory.model.action;

import java.util.List;

import br.com.mind5.business.orderHistory.info.OrdoryInfo;
import br.com.mind5.business.orderHistory.info.OrdoryMerger;
import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.decisionTree.OrdistRootSearchAuth;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdoryMergeOrdistSearchAuth extends ActionVisitorTemplateMerge<OrdoryInfo, OrdistInfo> {
	
	public VisiOrdoryMergeOrdistSearchAuth(DeciTreeOption<OrdoryInfo> option) {
		super(option, OrdistInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdistInfo>> getTreeClassHook() {
		return OrdistRootSearchAuth.class;
	}
	
	
	
	@Override protected List<OrdoryInfo> mergeHook(List<OrdoryInfo> baseInfos, List<OrdistInfo> selectedInfos) {	
		return OrdoryMerger.mergeWithOrdist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
