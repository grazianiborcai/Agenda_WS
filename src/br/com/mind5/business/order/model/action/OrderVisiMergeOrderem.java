package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.decisionTree.RootOrderemSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderVisiMergeOrderem extends ActionVisitorTemplateMerge<OrderInfo, OrderemInfo> {
	
	public OrderVisiMergeOrderem(DeciTreeOption<OrderInfo> option) { 
		super(option, OrderemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderemInfo>> getTreeClassHook() {
		return RootOrderemSearch.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> baseInfos, List<OrderemInfo> selectedInfos) {	
		return OrderMerger.mergeWithOrderem(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
