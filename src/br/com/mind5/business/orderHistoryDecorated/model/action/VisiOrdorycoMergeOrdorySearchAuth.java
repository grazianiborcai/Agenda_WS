package br.com.mind5.business.orderHistoryDecorated.model.action;

import java.util.List;

import br.com.mind5.business.orderHistory.info.OrdoryInfo;
import br.com.mind5.business.orderHistory.model.decisionTree.OrdoryRootSearchAuth;
import br.com.mind5.business.orderHistoryDecorated.info.OrdorycoInfo;
import br.com.mind5.business.orderHistoryDecorated.info.OrdorycoMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdorycoMergeOrdorySearchAuth extends ActionVisitorTemplateMerge<OrdorycoInfo, OrdoryInfo> {
	
	public VisiOrdorycoMergeOrdorySearchAuth(DeciTreeOption<OrdorycoInfo> option) {
		super(option, OrdoryInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdoryInfo>> getTreeClassHook() {
		return OrdoryRootSearchAuth.class;
	}
	
	
	
	@Override protected List<OrdorycoInfo> mergeHook(List<OrdorycoInfo> baseInfos, List<OrdoryInfo> selectedInfos) {	
		return OrdorycoMerger.mergeWithOrdory(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
