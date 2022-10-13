package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.personLegal.info.PeregCopier;
import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.model.decisionTree.PeregRootUpdate;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiPeregUpdate extends ActionVisitorTemplateAction<StoreInfo, PeregInfo> {
	
	public StoreVisiPeregUpdate(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, PeregInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PeregInfo>> getTreeClassHook() {
		return PeregRootUpdate.class;
	}
	
	
	
	@Override protected List<PeregInfo> toActionClassHook(List<StoreInfo> recordInfos) {		
		return PeregCopier.copyFromStore(recordInfos);
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<PeregInfo> results) {
		return StoreMerger.mergeWithPereg(baseInfos, results);
	}
}
