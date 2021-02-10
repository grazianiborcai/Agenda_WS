package br.com.mind5.business.orderItemCounter.model.action;

import java.util.List;

import br.com.mind5.business.orderItemCounter.info.OrdereouInfo;
import br.com.mind5.business.orderItemCounter.info.OrdereouMerger;
import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.business.orderItemList.model.decisionTree.RootOrdemistSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdereouMergeOrdemist extends ActionVisitorTemplateMerge<OrdereouInfo, OrdemistInfo> {
	
	public VisiOrdereouMergeOrdemist(DeciTreeOption<OrdereouInfo> option) {
		super(option, OrdemistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdemistInfo>> getTreeClassHook() {
		return RootOrdemistSearch.class;
	}
	
	
	
	@Override protected List<OrdereouInfo> mergeHook(List<OrdereouInfo> baseInfos, List<OrdemistInfo> selectedInfos) {	
		return OrdereouMerger.mergeWithOrdemist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
