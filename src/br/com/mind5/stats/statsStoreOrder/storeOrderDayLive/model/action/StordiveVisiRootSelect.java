package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.decisionTree.StordiveRootSelect;

public final class StordiveVisiRootSelect extends ActionVisitorTemplateAction<StordiveInfo, StordiveInfo> {

	public StordiveVisiRootSelect(DeciTreeOption<StordiveInfo> option) {
		super(option, StordiveInfo.class, StordiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StordiveInfo>> getTreeClassHook() {
		return StordiveRootSelect.class;
	}
	
	
	
	@Override protected List<StordiveInfo> toBaseClassHook(List<StordiveInfo> baseInfos, List<StordiveInfo> results) {
		return results;
	}
}
