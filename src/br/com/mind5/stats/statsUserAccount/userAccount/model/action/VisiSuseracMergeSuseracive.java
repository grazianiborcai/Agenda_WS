package br.com.mind5.stats.statsUserAccount.userAccount.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccount.info.SuseracInfo;
import br.com.mind5.stats.statsUserAccount.userAccount.info.SuseracMerger;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.SuseraciveInfo;
import br.com.mind5.stats.statsUserAccount.userAccountLive.model.decisionTree.RootSuseraciveSelect;

final class VisiSuseracMergeSuseracive extends ActionVisitorTemplateMerge<SuseracInfo, SuseraciveInfo> {
	
	public VisiSuseracMergeSuseracive(DeciTreeOption<SuseracInfo> option) {
		super(option, SuseraciveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SuseraciveInfo>> getTreeClassHook() {
		return RootSuseraciveSelect.class;
	}
	
	
	
	@Override protected List<SuseracInfo> mergeHook(List<SuseracInfo> baseInfos, List<SuseraciveInfo> selectedInfos) {	
		return SuseracMerger.mergeWithStoracive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
