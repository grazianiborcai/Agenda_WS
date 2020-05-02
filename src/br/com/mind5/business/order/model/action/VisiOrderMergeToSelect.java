package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderMergeToSelect extends ActionVisitorTemplateMergeV2<OrderInfo, OrderInfo> {
	
	public VisiOrderMergeToSelect(DeciTreeOption<OrderInfo> option) {
		super(option, OrderInfo.class); 
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<OrderInfo>> getActionClassHook() {
		return StdOrderDaoSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> baseInfos, List<OrderInfo> selectedInfos) {	
		return OrderMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
