package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.business.orderStatusChange.info.OrdugeCopier;
import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.business.orderStatusChange.model.decisionTree.RootOrdugeCreate;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderVisiMergeOrdugeCreate extends ActionVisitorTemplateMerge<OrderInfo, OrdugeInfo> {
	
	public OrderVisiMergeOrdugeCreate(DeciTreeOption<OrderInfo> option) { 
		super(option, OrdugeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdugeInfo>> getTreeClassHook() {
		return RootOrdugeCreate.class;
	}
	
	
	
	@Override protected List<OrdugeInfo> toActionClassHook(List<OrderInfo> baseInfos) {
		return OrdugeCopier.copyFromOrder(baseInfos);
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> baseInfos, List<OrdugeInfo> selectedInfos) {	
		return OrderMerger.mergeWithOrduge(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
