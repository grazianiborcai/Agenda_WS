package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.UserRootInsertOwner;

public final class OwnerVisiUserInsert extends ActionVisitorTemplateAction<OwnerInfo, UserInfo> {
	
	public OwnerVisiUserInsert(DeciTreeOption<OwnerInfo> option) {
		super(option, OwnerInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return UserRootInsertOwner.class;
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return UserCopier.copyFromOwner(recordInfos);
	}
	
	
	
	@Override protected List<OwnerInfo> toBaseClassHook(List<OwnerInfo> baseInfos, List<UserInfo> results) {
		return OwnerMerger.mergeWithUser(baseInfos, results);
	}
}
