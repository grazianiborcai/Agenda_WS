package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreCopier;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.decisionTree.MatoreRootDeleteFromStore;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiMatoreDelete extends ActionVisitorTemplateAction<StoreInfo, MatoreInfo> {
	
	public StoreVisiMatoreDelete(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, MatoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoreInfo>> getTreeClassHook() {
		return MatoreRootDeleteFromStore.class;
	}
	
	
	
	@Override protected List<MatoreInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return MatoreCopier.copyFromStore(recordInfos);
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<MatoreInfo> results) {
		return baseInfos;
	}
}
