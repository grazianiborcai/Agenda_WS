package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeText.info.StorextCopier;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.decisionTree.RootStorextInsert;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreStorextInsert extends ActionVisitorTemplateActionV2<StoreInfo, StorextInfo> {
	
	public VisiStoreStorextInsert(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, StorextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorextInfo>> getTreeClassHook() {
		return RootStorextInsert.class;
	}
	
	
	
	@Override protected List<StorextInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return StorextCopier.copyFromStore(recordInfos);
	}
	
	
	
	protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<StorextInfo> results) {
		return baseInfos;
	}
}
