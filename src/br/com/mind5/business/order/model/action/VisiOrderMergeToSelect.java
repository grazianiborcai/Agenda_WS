package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderMergeToSelect extends ActionVisitorTemplateMerge<OrderInfo, OrderInfo> {
	
	public VisiOrderMergeToSelect(DeciTreeOption<OrderInfo> option) {
		super(option, OrderInfo.class); 
	}
	
	
	
	@Override protected Class<? extends ActionStd<OrderInfo>> getActionClassHook() {
		return StdOrderDaoSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> baseInfos, List<OrderInfo> selectedInfos) {	
		return OrderMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
