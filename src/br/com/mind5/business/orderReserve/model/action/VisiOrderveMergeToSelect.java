package br.com.mind5.business.orderReserve.model.action;

import java.util.List;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.info.OrderveMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderveMergeToSelect extends ActionVisitorTemplateMergeV2<OrderveInfo, OrderveInfo> {
	
	public VisiOrderveMergeToSelect(DeciTreeOption<OrderveInfo> option) {
		super(option, OrderveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<OrderveInfo>> getActionClassHook() {
		return StdOrderveDaoSelect.class;
	}
	
	
	
	@Override protected List<OrderveInfo> mergeHook(List<OrderveInfo> baseInfos, List<OrderveInfo> selectedInfos) {	
		return OrderveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
