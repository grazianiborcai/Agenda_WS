package br.com.mind5.business.orderReserve.model.action;

import java.util.List;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.info.OrderveMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderveVisiMergeToSelect extends ActionVisitorTemplateMerge<OrderveInfo, OrderveInfo> {
	
	public OrderveVisiMergeToSelect(DeciTreeOption<OrderveInfo> option) {
		super(option, OrderveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<OrderveInfo>> getVisitorClassHook() {
		return OrderveVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<OrderveInfo> mergeHook(List<OrderveInfo> baseInfos, List<OrderveInfo> selectedInfos) {	
		return OrderveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
