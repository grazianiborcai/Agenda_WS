package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserInsertAnonymous;

final class VisiOwnerUserInsertAnonymous extends ActionVisitorTemplateActionV2<OwnerInfo, UserInfo> {
	
	public VisiOwnerUserInsertAnonymous(DeciTreeOption<OwnerInfo> option) {
		super(option, OwnerInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserInsertAnonymous.class;
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return UserCopier.copyFromOwner(recordInfos);
	}
	
	
	
	@Override protected List<OwnerInfo> toBaseClassHook(List<OwnerInfo> baseInfos, List<UserInfo> results) {
		return OwnerMerger.mergeWithDaemon(baseInfos, results);
	}
}
