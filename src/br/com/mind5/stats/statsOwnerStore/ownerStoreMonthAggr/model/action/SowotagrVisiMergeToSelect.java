package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrMerger;

public final class SowotagrVisiMergeToSelect extends ActionVisitorTemplateMerge<SowotagrInfo, SowotagrInfo> {
	
	public SowotagrVisiMergeToSelect(DeciTreeOption<SowotagrInfo> option) {
		super(option, SowotagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SowotagrInfo>> getVisitorClassHook() {
		return SowotagrVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SowotagrInfo> mergeHook(List<SowotagrInfo> baseInfos, List<SowotagrInfo> selectedInfos) {	
		return SowotagrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
