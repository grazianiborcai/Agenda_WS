package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonMerger;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.model.decisionTree.CutefilonagrRootSelect;

public final class CutefilonVisiMergeCutefilonagr extends ActionVisitorTemplateMerge<CutefilonInfo, CutefilonagrInfo> {
	
	public CutefilonVisiMergeCutefilonagr(DeciTreeOption<CutefilonInfo> option) {
		super(option, CutefilonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CutefilonagrInfo>> getTreeClassHook() {
		return CutefilonagrRootSelect.class;
	}
	
	
	
	@Override protected List<CutefilonInfo> mergeHook(List<CutefilonInfo> baseInfos, List<CutefilonagrInfo> selectedInfos) {	
		return CutefilonMerger.mergeWithCutefilonagr(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
