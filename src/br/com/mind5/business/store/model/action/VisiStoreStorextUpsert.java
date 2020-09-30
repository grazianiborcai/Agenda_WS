package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeText.info.StorextCopier;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.decisionTree.RootStorextUpsertdel;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreStorextUpsert extends ActionVisitorTemplateActionV2<StoreInfo, StorextInfo> {
	
	public VisiStoreStorextUpsert(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, StorextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorextInfo>> getTreeClassHook() {
		return RootStorextUpsertdel.class;
	}
	
	
	
	@Override protected List<StorextInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return StorextCopier.copyFromStore(recordInfos);
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<StorextInfo> results) {
		return baseInfos;
	}
}
