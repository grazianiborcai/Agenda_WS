package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemMerger;
import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.model.decisionTree.OrdemarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderemVisiMergeOrdemarch extends ActionVisitorTemplateMerge<OrderemInfo, OrdemarchInfo> {
	
	public OrderemVisiMergeOrdemarch(DeciTreeOption<OrderemInfo> option) {
		super(option, OrdemarchInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdemarchInfo>> getTreeClassHook() {
		return OrdemarchRootSelect.class;
	}
	
	
	
	@Override protected List<OrderemInfo> mergeHook(List<OrderemInfo> baseInfos, List<OrdemarchInfo> selectedInfos) {	
		return OrderemMerger.mergeWithOrdemarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
