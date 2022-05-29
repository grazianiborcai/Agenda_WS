package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.UserNodeSnapshot;

public final class UserVisiNodeSnapshot extends ActionVisitorTemplateAction<UserInfo, UserInfo> {

	public UserVisiNodeSnapshot(DeciTreeOption<UserInfo> option) {
		super(option, UserInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return UserNodeSnapshot.class;
	}
	
	
	
	@Override protected List<UserInfo> toBaseClassHook(List<UserInfo> baseInfos, List<UserInfo> results) {
		return results;
	}
}
