package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.masterData.orderStatus.model.decisionTree.RootOrderatusSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderVisiMergeOrderatus extends ActionVisitorTemplateMerge<OrderInfo, OrderatusInfo> {
	
	public OrderVisiMergeOrderatus(DeciTreeOption<OrderInfo> option) { 
		super(option, OrderatusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderatusInfo>> getTreeClassHook() {
		return RootOrderatusSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> baseInfos, List<OrderatusInfo> selectedInfos) {	
		return OrderMerger.mergeWithOrderatus(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
