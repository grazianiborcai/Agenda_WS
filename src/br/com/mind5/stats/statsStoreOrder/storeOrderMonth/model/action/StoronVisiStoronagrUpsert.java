package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronMerger;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.decisionTree.StoronagrRootUpsert;

public final class StoronVisiStoronagrUpsert extends ActionVisitorTemplateAction<StoronInfo, StoronagrInfo> {

	public StoronVisiStoronagrUpsert(DeciTreeOption<StoronInfo> option) {
		super(option, StoronInfo.class, StoronagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoronagrInfo>> getTreeClassHook() {
		return StoronagrRootUpsert.class;
	}
	
	
	
	@Override protected List<StoronInfo> toBaseClassHook(List<StoronInfo> baseInfos, List<StoronagrInfo> results) {
		return StoronMerger.mergeWithStoronagr(baseInfos, results);
	}
}
