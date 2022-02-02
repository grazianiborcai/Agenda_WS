package br.com.mind5.stats.statsStoreAccount.storeAccount.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.RootCalonthSelectLtm;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreAccount.storeAccount.info.StoracInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccount.info.StoracMerger;

final class VisiStoracMergeCalonthLtm extends ActionVisitorTemplateMerge<StoracInfo, CalonthInfo> {
	
	public VisiStoracMergeCalonthLtm(DeciTreeOption<StoracInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return RootCalonthSelectLtm.class;
	}
	
	
	
	@Override protected List<StoracInfo> mergeHook(List<StoracInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return StoracMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
