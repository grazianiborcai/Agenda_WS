package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveMerger;

public final class CutefiloniveVisiMergeToSelect extends ActionVisitorTemplateMerge<CutefiloniveInfo, CutefiloniveInfo> {
	
	public CutefiloniveVisiMergeToSelect(DeciTreeOption<CutefiloniveInfo> option) {
		super(option, CutefiloniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CutefiloniveInfo>> getVisitorClassHook() {
		return CutefiloniveVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CutefiloniveInfo> mergeHook(List<CutefiloniveInfo> baseInfos, List<CutefiloniveInfo> selectedInfos) {	
		return CutefiloniveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
