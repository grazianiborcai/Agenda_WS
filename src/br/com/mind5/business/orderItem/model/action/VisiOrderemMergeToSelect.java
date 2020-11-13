package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderemMergeToSelect extends ActionVisitorTemplateMerge<OrderemInfo, OrderemInfo> {
	
	public VisiOrderemMergeToSelect(DeciTreeOption<OrderemInfo> option) {
		super(option, OrderemInfo.class); 
	}
	
	
	
	@Override protected Class<? extends ActionStd<OrderemInfo>> getActionClassHook() {
		return StdOrderemDaoSelect.class;
	}
	
	
	
	@Override protected List<OrderemInfo> mergeHook(List<OrderemInfo> baseInfos, List<OrderemInfo> selectedInfos) {	
		return OrderemMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
