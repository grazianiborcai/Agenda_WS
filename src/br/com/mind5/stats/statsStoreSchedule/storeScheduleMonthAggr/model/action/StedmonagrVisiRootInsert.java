package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.decisionTree.StedmonagrRootInsert;

public final class StedmonagrVisiRootInsert extends ActionVisitorTemplateAction<StedmonagrInfo, StedmonagrInfo> {

	public StedmonagrVisiRootInsert(DeciTreeOption<StedmonagrInfo> option) {
		super(option, StedmonagrInfo.class, StedmonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StedmonagrInfo>> getTreeClassHook() {
		return StedmonagrRootInsert.class;
	}
	
	
	
	@Override protected List<StedmonagrInfo> toBaseClassHook(List<StedmonagrInfo> baseInfos, List<StedmonagrInfo> results) {
		return results;
	}
}
