package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchMerger;

public final class SowotarchVisiMergeToSelect extends ActionVisitorTemplateMerge<SowotarchInfo, SowotarchInfo> {
	
	public SowotarchVisiMergeToSelect(DeciTreeOption<SowotarchInfo> option) {
		super(option, SowotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SowotarchInfo>> getVisitorClassHook() {
		return SowotarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SowotarchInfo> mergeHook(List<SowotarchInfo> baseInfos, List<SowotarchInfo> selectedInfos) {	
		return SowotarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
