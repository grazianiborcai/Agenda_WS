package br.com.mind5.stats.statsOwnerUser.userAccountLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.info.SowusiveInfo;
import br.com.mind5.stats.statsOwnerUser.userAccountLive.info.SowusiveMerger;

final class VisiSowusiveMergeToSelect extends ActionVisitorTemplateMerge<SowusiveInfo, SowusiveInfo> {
	
	public VisiSowusiveMergeToSelect(DeciTreeOption<SowusiveInfo> option) {
		super(option, SowusiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SowusiveInfo>> getActionClassHook() {
		return StdSowusiveDaoSelect.class;
	}
	
	
	
	@Override protected List<SowusiveInfo> mergeHook(List<SowusiveInfo> baseInfos, List<SowusiveInfo> selectedInfos) {	
		return SowusiveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
