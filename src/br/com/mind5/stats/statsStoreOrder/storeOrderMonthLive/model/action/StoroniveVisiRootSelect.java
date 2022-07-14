package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.decisionTree.StoroniveRootSelect;

public final class StoroniveVisiRootSelect extends ActionVisitorTemplateAction<StoroniveInfo, StoroniveInfo> {

	public StoroniveVisiRootSelect(DeciTreeOption<StoroniveInfo> option) {
		super(option, StoroniveInfo.class, StoroniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoroniveInfo>> getTreeClassHook() {
		return StoroniveRootSelect.class;
	}
	
	
	
	@Override protected List<StoroniveInfo> toBaseClassHook(List<StoroniveInfo> baseInfos, List<StoroniveInfo> results) {
		return results;
	}
}
