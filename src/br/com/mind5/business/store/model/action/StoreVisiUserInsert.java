package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.UserRootInsertStore;

public final class StoreVisiUserInsert extends ActionVisitorTemplateAction<StoreInfo, UserInfo> {
	
	public StoreVisiUserInsert(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return UserRootInsertStore.class;
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return UserCopier.copyFromStore(recordInfos);
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<UserInfo> results) {
		return StoreMerger.mergeWithUser(baseInfos, results);
	}
}
