package br.com.mind5.business.orderItemCounter.model.action;

import java.util.List;

import br.com.mind5.business.orderItemCounter.info.OrdereouInfo;
import br.com.mind5.business.orderItemCounter.info.OrdereouMerger;
import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.model.decisionTree.RootOrdemarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdereouMergeOrdemarch extends ActionVisitorTemplateMerge<OrdereouInfo, OrdemarchInfo> {
	
	public VisiOrdereouMergeOrdemarch(DeciTreeOption<OrdereouInfo> option) {
		super(option, OrdemarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdemarchInfo>> getTreeClassHook() {
		return RootOrdemarchSelect.class;
	}
	
	
	
	@Override protected List<OrdereouInfo> mergeHook(List<OrdereouInfo> baseInfos, List<OrdemarchInfo> selectedInfos) {	
		return OrdereouMerger.mergeWithOrdemarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
