package br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrMerger;

public final class StefilonagrVisiMergeToSelect extends ActionVisitorTemplateMerge<StefilonagrInfo, StefilonagrInfo> {
	
	public StefilonagrVisiMergeToSelect(DeciTreeOption<StefilonagrInfo> option) {
		super(option, StefilonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StefilonagrInfo>> getVisitorClassHook() {
		return StefilonagrVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StefilonagrInfo> mergeHook(List<StefilonagrInfo> baseInfos, List<StefilonagrInfo> selectedInfos) {	
		return StefilonagrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
