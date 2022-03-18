package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.decisionTree.StedmonRootSelect;

public final class StedmonVisiRootSelect extends ActionVisitorTemplateAction<StedmonInfo, StedmonInfo> {

	public StedmonVisiRootSelect(DeciTreeOption<StedmonInfo> option) {
		super(option, StedmonInfo.class, StedmonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StedmonInfo>> getTreeClassHook() {
		return StedmonRootSelect.class;
	}
	
	
	
	@Override protected List<StedmonInfo> toBaseClassHook(List<StedmonInfo> baseInfos, List<StedmonInfo> results) {
		return results;
	}
}
