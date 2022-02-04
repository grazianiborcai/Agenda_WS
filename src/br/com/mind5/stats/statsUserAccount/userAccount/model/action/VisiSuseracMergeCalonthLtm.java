package br.com.mind5.stats.statsUserAccount.userAccount.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.RootCalonthSelectLtm;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccount.info.SuseracInfo;
import br.com.mind5.stats.statsUserAccount.userAccount.info.SuseracMerger;

final class VisiSuseracMergeCalonthLtm extends ActionVisitorTemplateMerge<SuseracInfo, CalonthInfo> {
	
	public VisiSuseracMergeCalonthLtm(DeciTreeOption<SuseracInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return RootCalonthSelectLtm.class;
	}
	
	
	
	@Override protected List<SuseracInfo> mergeHook(List<SuseracInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return SuseracMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
