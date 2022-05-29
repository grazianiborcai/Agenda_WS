package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.UserRootInsertCus;

public final class UserVisiRootInsertCus extends ActionVisitorTemplateAction<UserInfo, UserInfo> {

	public UserVisiRootInsertCus(DeciTreeOption<UserInfo> option) {
		super(option, UserInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return UserRootInsertCus.class;
	}
	
	
	
	@Override protected List<UserInfo> toBaseClassHook(List<UserInfo> baseInfos, List<UserInfo> results) {
		return results;
	}
}
