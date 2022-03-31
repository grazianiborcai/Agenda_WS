package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeText.info.StorextCopier;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.decisionTree.StorextRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiStorextInsert extends ActionVisitorTemplateAction<StoreInfo, StorextInfo> {
	
	public StoreVisiStorextInsert(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, StorextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorextInfo>> getTreeClassHook() {
		return StorextRootInsert.class;
	}
	
	
	
	@Override protected List<StorextInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return StorextCopier.copyFromStore(recordInfos);
	}
	
	
	
	protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<StorextInfo> results) {
		return baseInfos;
	}
}
