package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronMerger;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.decisionTree.RootStoroniveSelect;

public final class StoronVisiMergeStoronive extends ActionVisitorTemplateMerge<StoronInfo, StoroniveInfo> {
	
	public StoronVisiMergeStoronive(DeciTreeOption<StoronInfo> option) {
		super(option, StoroniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoroniveInfo>> getTreeClassHook() {
		return RootStoroniveSelect.class;
	}
	
	
	
	@Override protected List<StoronInfo> mergeHook(List<StoronInfo> baseInfos, List<StoroniveInfo> selectedInfos) {	
		return StoronMerger.mergeWithStoronive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
