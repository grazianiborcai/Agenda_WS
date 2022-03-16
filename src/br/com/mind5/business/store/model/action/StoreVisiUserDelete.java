package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserDelete;

public final class StoreVisiUserDelete extends ActionVisitorTemplateAction<StoreInfo, UserInfo> {
	
	public StoreVisiUserDelete(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserDelete.class;
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return UserCopier.copyFromStoreKey(recordInfos);
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<UserInfo> results) {
		return baseInfos;
	}
}
