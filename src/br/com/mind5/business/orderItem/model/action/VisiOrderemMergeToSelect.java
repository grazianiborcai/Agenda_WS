package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderemMergeToSelect extends ActionVisitorTemplateMergeV2<OrderemInfo, OrderemInfo> {
	
	public VisiOrderemMergeToSelect(DeciTreeOption<OrderemInfo> option) {
		super(option, OrderemInfo.class); 
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<OrderemInfo>> getActionClassHook() {
		return StdOrderemDaoSelect.class;
	}
	
	
	
	@Override protected List<OrderemInfo> mergeHook(List<OrderemInfo> baseInfos, List<OrderemInfo> selectedInfos) {	
		return OrderemMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
