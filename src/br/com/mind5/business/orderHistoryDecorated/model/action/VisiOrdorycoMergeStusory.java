package br.com.mind5.business.orderHistoryDecorated.model.action;

import java.util.List;

import br.com.mind5.business.orderHistoryDecorated.info.OrdorycoInfo;
import br.com.mind5.business.orderHistoryDecorated.info.OrdorycoMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.decisionTree.RootStusorySearchByUser;

final class VisiOrdorycoMergeStusory extends ActionVisitorTemplateMerge<OrdorycoInfo, StusoryInfo> {
	
	public VisiOrdorycoMergeStusory(DeciTreeOption<OrdorycoInfo> option) {
		super(option, StusoryInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<StusoryInfo>> getTreeClassHook() {
		return RootStusorySearchByUser.class;
	}
	
	
	
	@Override protected List<OrdorycoInfo> mergeHook(List<OrdorycoInfo> baseInfos, List<StusoryInfo> selectedInfos) {	
		return OrdorycoMerger.mergeWithStusory(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
