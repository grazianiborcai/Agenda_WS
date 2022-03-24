package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.masterData.feeCategory.model.decisionTree.RootFeecatSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderVisiMergeFeecat extends ActionVisitorTemplateMerge<OrderInfo, FeecatInfo> {
	
	public OrderVisiMergeFeecat(DeciTreeOption<OrderInfo> option) { 
		super(option, FeecatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeecatInfo>> getTreeClassHook() {
		return RootFeecatSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> baseInfos, List<FeecatInfo> selectedInfos) {	
		return OrderMerger.mergeWithFeecat(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
