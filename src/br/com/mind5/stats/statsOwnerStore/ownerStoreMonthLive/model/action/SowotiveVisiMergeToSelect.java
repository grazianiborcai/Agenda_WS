package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.info.SowotiveInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.info.SowotiveMerger;

public final class SowotiveVisiMergeToSelect extends ActionVisitorTemplateMerge<SowotiveInfo, SowotiveInfo> {
	
	public SowotiveVisiMergeToSelect(DeciTreeOption<SowotiveInfo> option) {
		super(option, SowotiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SowotiveInfo>> getVisitorClassHook() {
		return SowotiveVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SowotiveInfo> mergeHook(List<SowotiveInfo> baseInfos, List<SowotiveInfo> selectedInfos) {	
		return SowotiveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
