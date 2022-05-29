package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.UserNodeInsert;

public final class UserVisiNodeInsert extends ActionVisitorTemplateAction<UserInfo, UserInfo> {

	public UserVisiNodeInsert(DeciTreeOption<UserInfo> option) {
		super(option, UserInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return UserNodeInsert.class;
	}
	
	
	
	@Override protected List<UserInfo> toBaseClassHook(List<UserInfo> baseInfos, List<UserInfo> results) {
		return results;
	}
}
