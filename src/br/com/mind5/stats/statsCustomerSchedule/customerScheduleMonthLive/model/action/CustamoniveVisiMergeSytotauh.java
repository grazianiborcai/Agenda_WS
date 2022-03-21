package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.decisionTree.RootSytotauhSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveMerger;

public final class CustamoniveVisiMergeSytotauh extends ActionVisitorTemplateMerge<CustamoniveInfo, SytotauhInfo> {
	
	public CustamoniveVisiMergeSytotauh(DeciTreeOption<CustamoniveInfo> option) {
		super(option, SytotauhInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SytotauhInfo>> getTreeClassHook() {
		return RootSytotauhSelect.class;
	}
	
	
	
	@Override protected List<CustamoniveInfo> mergeHook(List<CustamoniveInfo> recordInfos, List<SytotauhInfo> selectedInfos) {	
		return CustamoniveMerger.mergeWithSytotauh(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
