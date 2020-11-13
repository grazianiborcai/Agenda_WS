package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.business.storeSnapshot.info.StorapCopier;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.model.decisionTree.RootStorapInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreStorapInsert extends ActionVisitorTemplateAction<StoreInfo, StorapInfo> {

	public VisiStoreStorapInsert(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, StorapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorapInfo>> getTreeClassHook() {
		return RootStorapInsert.class;
	}
	
	
	
	@Override protected List<StorapInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return StorapCopier.copyFromStore(recordInfos);
	}
	
	
	
	protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<StorapInfo> results) {
		return StoreMerger.mergeWithStorap(baseInfos, results);
	}
}
