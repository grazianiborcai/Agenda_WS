package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeLunchTime.info.StuntmCopier;
import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.decisionTree.StuntmRootUpsertdel;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiStuntmUpsertdel extends ActionVisitorTemplateAction<StoreInfo, StuntmInfo> {
	
	public StoreVisiStuntmUpsertdel(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, StuntmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StuntmInfo>> getTreeClassHook() {
		return StuntmRootUpsertdel.class;
	}
	
	
	
	@Override protected List<StuntmInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return StuntmCopier.copyFromStore(recordInfos);
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<StuntmInfo> results) {
		return baseInfos;	
	}
}
