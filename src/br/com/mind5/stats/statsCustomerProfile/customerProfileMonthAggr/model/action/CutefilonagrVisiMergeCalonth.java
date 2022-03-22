package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.CalonthRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrMerger;

public final class CutefilonagrVisiMergeCalonth extends ActionVisitorTemplateMerge<CutefilonagrInfo, CalonthInfo> {
	
	public CutefilonagrVisiMergeCalonth(DeciTreeOption<CutefilonagrInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return CalonthRootSelect.class;
	}
	
	
	
	@Override protected List<CutefilonagrInfo> mergeHook(List<CutefilonagrInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return CutefilonagrMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
