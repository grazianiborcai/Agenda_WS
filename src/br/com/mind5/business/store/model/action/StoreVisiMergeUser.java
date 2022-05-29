package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.UserRootSelect;

public final class StoreVisiMergeUser extends ActionVisitorTemplateMerge<StoreInfo, UserInfo> {
	
	public StoreVisiMergeUser(DeciTreeOption<StoreInfo> option) {
		super(option, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return UserRootSelect.class;
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<StoreInfo> baseInfos) {
		return UserCopier.copyFromStoreKey(baseInfos);	
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> baseInfos, List<UserInfo> selectedInfos) {	
		return StoreMerger.mergeWithUser(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
