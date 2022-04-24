package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.decisionTree.StuntmRootDeleteFromStore;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiStuntmDelete extends ActionVisitorTemplateAction<StoreInfo, StuntmInfo> {
	
	public StoreVisiStuntmDelete(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, StuntmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StuntmInfo>> getTreeClassHook() {
		return StuntmRootDeleteFromStore.class;
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<StuntmInfo> results) {
		return baseInfos;
	}
}
