package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmCopier;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.decisionTree.StowotmRootUpsertdel;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiStowotmUpsertdel extends ActionVisitorTemplateAction<StoreInfo, StowotmInfo> {
	
	public StoreVisiStowotmUpsertdel(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, StowotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StowotmInfo>> getTreeClassHook() {
		return StowotmRootUpsertdel.class;
	}
	
	
	
	@Override protected List<StowotmInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return StowotmCopier.copyFromStore(recordInfos);
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<StowotmInfo> results) {
		return baseInfos;	
	}
}
