package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemMerger;
import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.model.decisionTree.RootOrdemarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderemMergeOrdemarch extends ActionVisitorTemplateMergeV2<OrderemInfo, OrdemarchInfo> {
	
	public VisiOrderemMergeOrdemarch(DeciTreeOption<OrderemInfo> option) {
		super(option, OrdemarchInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdemarchInfo>> getTreeClassHook() {
		return RootOrdemarchSelect.class;
	}
	
	
	
	@Override protected List<OrderemInfo> mergeHook(List<OrderemInfo> baseInfos, List<OrdemarchInfo> selectedInfos) {	
		return OrderemMerger.mergeWithOrdemarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
