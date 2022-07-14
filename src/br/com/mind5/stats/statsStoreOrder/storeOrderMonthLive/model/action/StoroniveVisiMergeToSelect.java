package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveMerger;

public final class StoroniveVisiMergeToSelect extends ActionVisitorTemplateMerge<StoroniveInfo, StoroniveInfo> {
	
	public StoroniveVisiMergeToSelect(DeciTreeOption<StoroniveInfo> option) {
		super(option, StoroniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StoroniveInfo>> getVisitorClassHook() {
		return StoroniveVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StoroniveInfo> mergeHook(List<StoroniveInfo> baseInfos, List<StoroniveInfo> selectedInfos) {	
		return StoroniveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
