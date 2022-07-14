package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.decisionTree.StordagrRootInsert;

public final class StordagrVisiRootInsert extends ActionVisitorTemplateAction<StordagrInfo, StordagrInfo> {

	public StordagrVisiRootInsert(DeciTreeOption<StordagrInfo> option) {
		super(option, StordagrInfo.class, StordagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StordagrInfo>> getTreeClassHook() {
		return StordagrRootInsert.class;
	}
	
	
	
	@Override protected List<StordagrInfo> toBaseClassHook(List<StordagrInfo> baseInfos, List<StordagrInfo> results) {
		return results;
	}
}
