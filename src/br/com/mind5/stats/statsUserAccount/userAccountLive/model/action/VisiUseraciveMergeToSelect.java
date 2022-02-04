package br.com.mind5.stats.statsUserAccount.userAccountLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveInfo;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveMerger;

final class VisiUseraciveMergeToSelect extends ActionVisitorTemplateMerge<UseraciveInfo, UseraciveInfo> {
	
	public VisiUseraciveMergeToSelect(DeciTreeOption<UseraciveInfo> option) {
		super(option, UseraciveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<UseraciveInfo>> getActionClassHook() {
		return StdUseraciveDaoSelect.class;
	}
	
	
	
	@Override protected List<UseraciveInfo> mergeHook(List<UseraciveInfo> baseInfos, List<UseraciveInfo> selectedInfos) {	
		return UseraciveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
