package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.CalonthRootSelectLtmNow;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronMerger;

public final class StoronVisiMergeCalonthLtm extends ActionVisitorTemplateMerge<StoronInfo, CalonthInfo> {
	
	public StoronVisiMergeCalonthLtm(DeciTreeOption<StoronInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return CalonthRootSelectLtmNow.class;
	}
	
	
	
	@Override protected List<StoronInfo> mergeHook(List<StoronInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return StoronMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
