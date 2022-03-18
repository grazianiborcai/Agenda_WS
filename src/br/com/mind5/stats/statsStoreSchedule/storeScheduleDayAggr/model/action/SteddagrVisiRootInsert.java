package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.decisionTree.SteddagrRootInsert;

public final class SteddagrVisiRootInsert extends ActionVisitorTemplateAction<SteddagrInfo, SteddagrInfo> {

	public SteddagrVisiRootInsert(DeciTreeOption<SteddagrInfo> option) {
		super(option, SteddagrInfo.class, SteddagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SteddagrInfo>> getTreeClassHook() {
		return SteddagrRootInsert.class;
	}
	
	
	
	@Override protected List<SteddagrInfo> toBaseClassHook(List<SteddagrInfo> baseInfos, List<SteddagrInfo> results) {
		return results;
	}
}
