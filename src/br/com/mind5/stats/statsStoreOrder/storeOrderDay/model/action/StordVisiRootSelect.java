package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.decisionTree.StordRootSelect;

public final class StordVisiRootSelect extends ActionVisitorTemplateAction<StordInfo, StordInfo> {

	public StordVisiRootSelect(DeciTreeOption<StordInfo> option) {
		super(option, StordInfo.class, StordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StordInfo>> getTreeClassHook() {
		return StordRootSelect.class;
	}
	
	
	
	@Override protected List<StordInfo> toBaseClassHook(List<StordInfo> baseInfos, List<StordInfo> results) {
		return results;
	}
}
