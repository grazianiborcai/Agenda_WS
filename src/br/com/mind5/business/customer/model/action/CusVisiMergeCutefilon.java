package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.decisionTree.CutefilonRootSelectNow;

public final class CusVisiMergeCutefilon extends ActionVisitorTemplateMerge<CusInfo, CutefilonInfo> {
	
	public CusVisiMergeCutefilon(DeciTreeOption<CusInfo> option) {
		super(option, CutefilonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CutefilonInfo>> getTreeClassHook() {
		return CutefilonRootSelectNow.class;
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> baseInfos, List<CutefilonInfo> selectedInfos) {	
		return CusMerger.mergeWithCutefilon(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
