package br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info.SowusiveInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info.SowusiveMerger;

public final class SowusiveVisiMergeToSelect extends ActionVisitorTemplateMerge<SowusiveInfo, SowusiveInfo> {
	
	public SowusiveVisiMergeToSelect(DeciTreeOption<SowusiveInfo> option) {
		super(option, SowusiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SowusiveInfo>> getVisitorClassHook() {
		return SowusiveVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SowusiveInfo> mergeHook(List<SowusiveInfo> baseInfos, List<SowusiveInfo> selectedInfos) {	
		return SowusiveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
