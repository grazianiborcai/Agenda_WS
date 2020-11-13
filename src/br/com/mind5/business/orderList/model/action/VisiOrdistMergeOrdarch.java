package br.com.mind5.business.orderList.model.action;

import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.info.OrdistMerger;
import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.model.decisionTree.RootOrdarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdistMergeOrdarch extends ActionVisitorTemplateMerge<OrdistInfo, OrdarchInfo> {
	
	public VisiOrdistMergeOrdarch(DeciTreeOption<OrdistInfo> option) {
		super(option, OrdarchInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdarchInfo>> getTreeClassHook() {
		return RootOrdarchSelect.class;
	}
	
	
	
	@Override protected List<OrdistInfo> mergeHook(List<OrdistInfo> baseInfos, List<OrdarchInfo> selectedInfos) {	
		return OrdistMerger.mergeWithOrdarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
