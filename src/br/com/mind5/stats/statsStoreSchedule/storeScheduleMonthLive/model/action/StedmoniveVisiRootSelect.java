package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.decisionTree.StedmoniveRootSelect;

public final class StedmoniveVisiRootSelect extends ActionVisitorTemplateAction<StedmoniveInfo, StedmoniveInfo> {

	public StedmoniveVisiRootSelect(DeciTreeOption<StedmoniveInfo> option) {
		super(option, StedmoniveInfo.class, StedmoniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StedmoniveInfo>> getTreeClassHook() {
		return StedmoniveRootSelect.class;
	}
	
	
	
	@Override protected List<StedmoniveInfo> toBaseClassHook(List<StedmoniveInfo> baseInfos, List<StedmoniveInfo> results) {
		return results;
	}
}
