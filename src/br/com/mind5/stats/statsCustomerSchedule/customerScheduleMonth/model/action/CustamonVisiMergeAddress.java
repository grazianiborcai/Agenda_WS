package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.AddressRootSelectCusDefault;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonMerger;

public final class CustamonVisiMergeAddress extends ActionVisitorTemplateMerge<CustamonInfo, AddressInfo> {
	
	public CustamonVisiMergeAddress(DeciTreeOption<CustamonInfo> option) {
		super(option, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return AddressRootSelectCusDefault.class;
	}
	
	
	
	@Override protected List<CustamonInfo> mergeHook(List<CustamonInfo> baseInfos, List<AddressInfo> selectedInfos) {	
		return CustamonMerger.mergeWithAddress(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
