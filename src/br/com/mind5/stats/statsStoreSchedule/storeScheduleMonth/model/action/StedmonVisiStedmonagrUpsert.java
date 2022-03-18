package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonMerger;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.decisionTree.RootStedmonagrUpsert;

public final class StedmonVisiStedmonagrUpsert extends ActionVisitorTemplateAction<StedmonInfo, StedmonagrInfo> {

	public StedmonVisiStedmonagrUpsert(DeciTreeOption<StedmonInfo> option) {
		super(option, StedmonInfo.class, StedmonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StedmonagrInfo>> getTreeClassHook() {
		return RootStedmonagrUpsert.class;
	}
	
	
	
	@Override protected List<StedmonInfo> toBaseClassHook(List<StedmonInfo> baseInfos, List<StedmonagrInfo> results) {
		return StedmonMerger.mergeWithStedmonagr(baseInfos, results);
	}
}
