package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.model.decisionTree.PeregRootDelete;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiPeregDelete extends ActionVisitorTemplateAction<StoreInfo, PeregInfo> {
	
	public StoreVisiPeregDelete(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, PeregInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PeregInfo>> getTreeClassHook() {
		return PeregRootDelete.class;
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<PeregInfo> results) {
		return StoreMerger.mergeWithPereg(baseInfos, results);
	}
}
