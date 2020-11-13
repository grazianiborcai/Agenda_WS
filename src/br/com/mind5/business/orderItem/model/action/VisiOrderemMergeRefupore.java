package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemMerger;
import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.decisionTree.RootRefuporeSelectFallback;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderemMergeRefupore extends ActionVisitorTemplateMerge<OrderemInfo, RefuporeInfo> {
	
	public VisiOrderemMergeRefupore(DeciTreeOption<OrderemInfo> option) {
		super(option, RefuporeInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefuporeInfo>> getTreeClassHook() {
		return RootRefuporeSelectFallback.class;
	}
	
	
	
	@Override protected List<OrderemInfo> mergeHook(List<OrderemInfo> baseInfos, List<RefuporeInfo> selectedInfos) {	
		return OrderemMerger.mergeWithRefupore(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
