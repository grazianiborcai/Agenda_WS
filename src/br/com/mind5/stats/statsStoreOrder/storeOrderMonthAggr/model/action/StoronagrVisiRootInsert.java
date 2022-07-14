package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.decisionTree.StoronagrRootInsert;

public final class StoronagrVisiRootInsert extends ActionVisitorTemplateAction<StoronagrInfo, StoronagrInfo> {

	public StoronagrVisiRootInsert(DeciTreeOption<StoronagrInfo> option) {
		super(option, StoronagrInfo.class, StoronagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoronagrInfo>> getTreeClassHook() {
		return StoronagrRootInsert.class;
	}
	
	
	
	@Override protected List<StoronagrInfo> toBaseClassHook(List<StoronagrInfo> baseInfos, List<StoronagrInfo> results) {
		return results;
	}
}
