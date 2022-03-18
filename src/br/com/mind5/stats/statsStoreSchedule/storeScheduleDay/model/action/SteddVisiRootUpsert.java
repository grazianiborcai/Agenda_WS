package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.decisionTree.SteddRootUpsert;

public final class SteddVisiRootUpsert extends ActionVisitorTemplateAction<SteddInfo, SteddInfo> {

	public SteddVisiRootUpsert(DeciTreeOption<SteddInfo> option) {
		super(option, SteddInfo.class, SteddInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SteddInfo>> getTreeClassHook() {
		return SteddRootUpsert.class;
	}
	
	
	
	@Override protected List<SteddInfo> toBaseClassHook(List<SteddInfo> baseInfos, List<SteddInfo> results) {
		return results;
	}
}
