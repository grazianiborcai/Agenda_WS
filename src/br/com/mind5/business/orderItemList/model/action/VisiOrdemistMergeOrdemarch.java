package br.com.mind5.business.orderItemList.model.action;

import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.business.orderItemList.info.OrdemistMerger;
import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.model.decisionTree.RootOrdemarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdemistMergeOrdemarch extends ActionVisitorTemplateMerge<OrdemistInfo, OrdemarchInfo> {
	
	public VisiOrdemistMergeOrdemarch(DeciTreeOption<OrdemistInfo> option) {
		super(option, OrdemarchInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdemarchInfo>> getTreeClassHook() {
		return RootOrdemarchSelect.class;
	}
	
	
	
	@Override protected List<OrdemistInfo> mergeHook(List<OrdemistInfo> baseInfos, List<OrdemarchInfo> selectedInfos) {	
		return OrdemistMerger.mergeWithOrdemarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
