package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.action;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.authorization.storePartitionAuthorization.model.decisionTree.SytotauhRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveMerger;

public final class SteddiveVisiMergeSytotauh extends ActionVisitorTemplateMerge<SteddiveInfo, SytotauhInfo> {
	
	public SteddiveVisiMergeSytotauh(DeciTreeOption<SteddiveInfo> option) {
		super(option, SytotauhInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SytotauhInfo>> getTreeClassHook() {
		return SytotauhRootSelect.class;
	}
	
	
	
	@Override protected List<SteddiveInfo> mergeHook(List<SteddiveInfo> recordInfos, List<SytotauhInfo> selectedInfos) {	
		return SteddiveMerger.mergeWithSytotauh(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
