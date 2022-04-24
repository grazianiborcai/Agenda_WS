package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.PhoneRootSearchUser;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserMerger;

final class VisiUserMergePhone extends ActionVisitorTemplateMerge<UserInfo, PhoneInfo> {
	
	public VisiUserMergePhone(DeciTreeOption<UserInfo> option) {
		super(option, PhoneInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return PhoneRootSearchUser.class;
	}
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> baseInfos, List<PhoneInfo> selectedInfos) {	
		return UserMerger.mergeWithPhone(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
