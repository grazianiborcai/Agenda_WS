package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordMerger;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.decisionTree.RootStordagrInsert;

final class VisiStordStordagrInsert extends ActionVisitorTemplateAction<StordInfo, StordagrInfo> {

	public VisiStordStordagrInsert(DeciTreeOption<StordInfo> option) {
		super(option, StordInfo.class, StordagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StordagrInfo>> getTreeClassHook() {
		return RootStordagrInsert.class;
	}
	
	
	
	@Override protected List<StordInfo> toBaseClassHook(List<StordInfo> baseInfos, List<StordagrInfo> results) {
		return StordMerger.mergeWithStordagr(baseInfos, results);
	}
}
