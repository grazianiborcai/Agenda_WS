package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.decisionTree.StoreNodeInsertPhone;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiNodeInsertPhone extends ActionVisitorTemplateAction<StoreInfo, StoreInfo> {

	public StoreVisiNodeInsertPhone(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, StoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoreInfo>> getTreeClassHook() {
		return StoreNodeInsertPhone.class;
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<StoreInfo> results) {
		return results;
	}
}
