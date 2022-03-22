package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.CalonthRootSelectNow;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonMerger;

public final class CutefilonVisiMergeCalonthNow extends ActionVisitorTemplateMerge<CutefilonInfo, CalonthInfo> {
	
	public CutefilonVisiMergeCalonthNow(DeciTreeOption<CutefilonInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return CalonthRootSelectNow.class;
	}
	
	
	
	@Override protected List<CutefilonInfo> mergeHook(List<CutefilonInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return CutefilonMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
