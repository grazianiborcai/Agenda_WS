package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.model.action;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.decisionTree.SytotauhRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveMerger;

public final class CutefiloniveVisiMergeSytotauh extends ActionVisitorTemplateMerge<CutefiloniveInfo, SytotauhInfo> {
	
	public CutefiloniveVisiMergeSytotauh(DeciTreeOption<CutefiloniveInfo> option) {
		super(option, SytotauhInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SytotauhInfo>> getTreeClassHook() {
		return SytotauhRootSelect.class;
	}
	
	
	
	@Override protected List<CutefiloniveInfo> mergeHook(List<CutefiloniveInfo> recordInfos, List<SytotauhInfo> selectedInfos) {	
		return CutefiloniveMerger.mergeWithSytotauh(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
