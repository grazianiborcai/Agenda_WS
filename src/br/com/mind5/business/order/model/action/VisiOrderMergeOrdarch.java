package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.model.decisionTree.RootOrdarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderMergeOrdarch extends ActionVisitorTemplateMergeV2<OrderInfo, OrdarchInfo> {
	
	public VisiOrderMergeOrdarch(DeciTreeOption<OrderInfo> option) {
		super(option, OrdarchInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdarchInfo>> getTreeClassHook() {
		return RootOrdarchSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> baseInfos, List<OrdarchInfo> selectedInfos) {	
		return OrderMerger.mergeWithOrdarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
