package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.decisionTree.SteddiveRootSelect;

public final class SteddiveVisiRootSelect extends ActionVisitorTemplateAction<SteddiveInfo, SteddiveInfo> {

	public SteddiveVisiRootSelect(DeciTreeOption<SteddiveInfo> option) {
		super(option, SteddiveInfo.class, SteddiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SteddiveInfo>> getTreeClassHook() {
		return SteddiveRootSelect.class;
	}
	
	
	
	@Override protected List<SteddiveInfo> toBaseClassHook(List<SteddiveInfo> baseInfos, List<SteddiveInfo> results) {
		return results;
	}
}
