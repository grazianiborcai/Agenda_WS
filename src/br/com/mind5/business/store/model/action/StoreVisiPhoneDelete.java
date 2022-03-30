package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneCopier;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.PhoneRootDelete;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiPhoneDelete extends ActionVisitorTemplateAction<StoreInfo, PhoneInfo> {
	
	public StoreVisiPhoneDelete(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return PhoneRootDelete.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return PhoneCopier.copyFromStore(recordInfos);
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<PhoneInfo> results) {
		return baseInfos;
	}
}
