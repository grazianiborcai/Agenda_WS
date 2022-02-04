package br.com.mind5.stats.statsUserAccount.userAccountLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.SuseraciveInfo;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.SuseraciveMerger;

final class VisiSuseraciveMergeToSelect extends ActionVisitorTemplateMerge<SuseraciveInfo, SuseraciveInfo> {
	
	public VisiSuseraciveMergeToSelect(DeciTreeOption<SuseraciveInfo> option) {
		super(option, SuseraciveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SuseraciveInfo>> getActionClassHook() {
		return StdSuseraciveDaoSelect.class;
	}
	
	
	
	@Override protected List<SuseraciveInfo> mergeHook(List<SuseraciveInfo> baseInfos, List<SuseraciveInfo> selectedInfos) {	
		return SuseraciveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
