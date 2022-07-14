package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.decisionTree.StoronRootSelect;

public final class StoronVisiRootSelect extends ActionVisitorTemplateAction<StoronInfo, StoronInfo> {

	public StoronVisiRootSelect(DeciTreeOption<StoronInfo> option) {
		super(option, StoronInfo.class, StoronInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoronInfo>> getTreeClassHook() {
		return StoronRootSelect.class;
	}
	
	
	
	@Override protected List<StoronInfo> toBaseClassHook(List<StoronInfo> baseInfos, List<StoronInfo> results) {
		return results;
	}
}
