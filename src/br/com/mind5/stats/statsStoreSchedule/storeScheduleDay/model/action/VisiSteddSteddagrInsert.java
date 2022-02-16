package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddMerger;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.decisionTree.RootSteddagrInsert;

final class VisiSteddSteddagrInsert extends ActionVisitorTemplateAction<SteddInfo, SteddagrInfo> {

	public VisiSteddSteddagrInsert(DeciTreeOption<SteddInfo> option) {
		super(option, SteddInfo.class, SteddagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SteddagrInfo>> getTreeClassHook() {
		return RootSteddagrInsert.class;
	}
	
	
	
	@Override protected List<SteddInfo> toBaseClassHook(List<SteddInfo> baseInfos, List<SteddagrInfo> results) {
		return SteddMerger.mergeWithSteddagr(baseInfos, results);
	}
}
