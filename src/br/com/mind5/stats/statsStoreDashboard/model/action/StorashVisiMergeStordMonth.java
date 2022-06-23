package br.com.mind5.stats.statsStoreDashboard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;
import br.com.mind5.stats.statsStoreDashboard.info.StorashMerger;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.decisionTree.RootStordSelectMonth;

public final class StorashVisiMergeStordMonth extends ActionVisitorTemplateMerge<StorashInfo, StordInfo> {
	
	public StorashVisiMergeStordMonth(DeciTreeOption<StorashInfo> option) {
		super(option, StordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StordInfo>> getTreeClassHook() {
		return RootStordSelectMonth.class;
	}
	
	
	
	@Override protected List<StorashInfo> mergeHook(List<StorashInfo> baseInfos, List<StordInfo> selectedInfos) {	
		return StorashMerger.mergeWithStord(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
