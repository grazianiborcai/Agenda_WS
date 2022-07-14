package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.decisionTree.StordRootUpsert;

public final class StordVisiRootUpsert extends ActionVisitorTemplateAction<StordInfo, StordInfo> {

	public StordVisiRootUpsert(DeciTreeOption<StordInfo> option) {
		super(option, StordInfo.class, StordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StordInfo>> getTreeClassHook() {
		return StordRootUpsert.class;
	}
	
	
	
	@Override protected List<StordInfo> toBaseClassHook(List<StordInfo> baseInfos, List<StordInfo> results) {
		return results;
	}
}
