package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.model.decisionTree.RootOrdemarchSelectOrder;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusMergeOrdemarch extends ActionVisitorTemplateMerge<CusInfo, OrdemarchInfo> {
	
	public VisiCusMergeOrdemarch(DeciTreeOption<CusInfo> option) {
		super(option, OrdemarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdemarchInfo>> getTreeClassHook() {
		return RootOrdemarchSelectOrder.class;
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> baseInfos, List<OrdemarchInfo> selectedInfos) {	
		return CusMerger.mergeWithOrdemarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
