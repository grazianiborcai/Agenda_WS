package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrMerger;

public final class CutefilonagrVisiMergeToSelect extends ActionVisitorTemplateMerge<CutefilonagrInfo, CutefilonagrInfo> {
	
	public CutefilonagrVisiMergeToSelect(DeciTreeOption<CutefilonagrInfo> option) {
		super(option, CutefilonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CutefilonagrInfo>> getVisitorClassHook() {
		return CutefilonagrVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CutefilonagrInfo> mergeHook(List<CutefilonagrInfo> baseInfos, List<CutefilonagrInfo> selectedInfos) {	
		return CutefilonagrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
