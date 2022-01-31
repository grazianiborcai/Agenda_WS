package br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveMerger;

final class VisiStoraciveMergeToSelect extends ActionVisitorTemplateMerge<StoraciveInfo, StoraciveInfo> {
	
	public VisiStoraciveMergeToSelect(DeciTreeOption<StoraciveInfo> option) {
		super(option, StoraciveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StoraciveInfo>> getActionClassHook() {
		return StdStoraciveDaoSelect.class;
	}
	
	
	
	@Override protected List<StoraciveInfo> mergeHook(List<StoraciveInfo> baseInfos, List<StoraciveInfo> selectedInfos) {	
		return StoraciveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
