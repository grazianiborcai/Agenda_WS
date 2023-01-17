package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.decisionTree.StoparRootCreate;

public final class StoreVisiStoparCreate extends ActionVisitorTemplateAction<StoreInfo, StoparInfo> {
	
	public StoreVisiStoparCreate(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, StoparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoparInfo>> getTreeClassHook() {
		return StoparRootCreate.class;
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<StoparInfo> results) {
		return baseInfos;
	}
}
