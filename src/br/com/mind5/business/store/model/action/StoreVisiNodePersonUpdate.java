package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.decisionTree.StoreNodePersonUpdate;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiNodePersonUpdate extends ActionVisitorTemplateAction<StoreInfo, StoreInfo> {

	public StoreVisiNodePersonUpdate(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, StoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoreInfo>> getTreeClassHook() {
		return StoreNodePersonUpdate.class;
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<StoreInfo> results) {
		return results;
	}
}
