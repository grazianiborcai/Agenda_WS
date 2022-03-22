package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonMerger;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.decisionTree.CutefiloniveRootSelect;

public final class CutefilonVisiMergeCutefilonive extends ActionVisitorTemplateMerge<CutefilonInfo, CutefiloniveInfo> {
	
	public CutefilonVisiMergeCutefilonive(DeciTreeOption<CutefilonInfo> option) {
		super(option, CutefiloniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CutefiloniveInfo>> getTreeClassHook() {
		return CutefiloniveRootSelect.class;
	}
	
	
	
	@Override protected List<CutefilonInfo> mergeHook(List<CutefilonInfo> baseInfos, List<CutefiloniveInfo> selectedInfos) {	
		return CutefilonMerger.mergeWithCutefilonive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
