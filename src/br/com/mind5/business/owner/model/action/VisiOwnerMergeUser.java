package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserSelect;

final class VisiOwnerMergeUser extends ActionVisitorTemplateMerge<OwnerInfo, UserInfo> {
	
	public VisiOwnerMergeUser(DeciTreeOption<OwnerInfo> option) {
		super(option, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserSelect.class;
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<OwnerInfo> baseInfos) {
		return UserCopier.copyFromOwnerKey(baseInfos);	
	}
	
	
	
	@Override protected List<OwnerInfo> mergeHook(List<OwnerInfo> baseInfos, List<UserInfo> selectedInfos) {	
		return OwnerMerger.mergeWithUser(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
