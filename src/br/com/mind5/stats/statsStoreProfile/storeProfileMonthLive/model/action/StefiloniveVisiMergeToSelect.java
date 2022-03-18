package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveMerger;

public final class StefiloniveVisiMergeToSelect extends ActionVisitorTemplateMerge<StefiloniveInfo, StefiloniveInfo> {
	
	public StefiloniveVisiMergeToSelect(DeciTreeOption<StefiloniveInfo> option) {
		super(option, StefiloniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StefiloniveInfo>> getVisitorClassHook() {
		return StefiloniveVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StefiloniveInfo> mergeHook(List<StefiloniveInfo> baseInfos, List<StefiloniveInfo> selectedInfos) {	
		return StefiloniveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
