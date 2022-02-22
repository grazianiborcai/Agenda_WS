package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.decisionTree.RootSytotauhSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveMerger;

final class VisiStedmoniveMergeSytotauh extends ActionVisitorTemplateMerge<StedmoniveInfo, SytotauhInfo> {
	
	public VisiStedmoniveMergeSytotauh(DeciTreeOption<StedmoniveInfo> option) {
		super(option, SytotauhInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SytotauhInfo>> getTreeClassHook() {
		return RootSytotauhSelect.class;
	}
	
	
	
	@Override protected List<StedmoniveInfo> mergeHook(List<StedmoniveInfo> recordInfos, List<SytotauhInfo> selectedInfos) {	
		return StedmoniveMerger.mergeWithSytotauh(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
