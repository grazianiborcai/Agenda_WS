package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderemVisiMergeToSelect extends ActionVisitorTemplateMerge<OrderemInfo, OrderemInfo> {
	
	public OrderemVisiMergeToSelect(DeciTreeOption<OrderemInfo> option) {
		super(option, OrderemInfo.class); 
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<OrderemInfo>> getVisitorClassHook() {
		return OrderemVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<OrderemInfo> mergeHook(List<OrderemInfo> baseInfos, List<OrderemInfo> selectedInfos) {	
		return OrderemMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
