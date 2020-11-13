package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.decisionTree.RootRefupownSelectFallback;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderMergeRefupown extends ActionVisitorTemplateMerge<OrderInfo, RefupownInfo> {
	
	public VisiOrderMergeRefupown(DeciTreeOption<OrderInfo> option) {
		super(option, RefupownInfo.class);
	}
	 
	
	
	@Override protected Class<? extends DeciTree<RefupownInfo>> getTreeClassHook() {
		return RootRefupownSelectFallback.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> baseInfos, List<RefupownInfo> selectedInfos) {	
		return OrderMerger.mergeWithRefupown(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
