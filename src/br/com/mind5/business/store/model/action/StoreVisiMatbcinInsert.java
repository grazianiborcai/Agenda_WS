package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.businessContent.material.main.model.decisionTree.RootMatbcinInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiMatbcinInsert extends ActionVisitorTemplateAction<StoreInfo, MatbcinInfo> {
	
	public StoreVisiMatbcinInsert(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, MatbcinInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatbcinInfo>> getTreeClassHook() {
		return RootMatbcinInsert.class;
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<MatbcinInfo> results) {
		return baseInfos;
	}
}
