package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.userPassword.info.UpswdCopier;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.decisionTree.RootUpswdInsertAnonymous;

public final class UserVisiUpswdInsertAnonymous extends ActionVisitorTemplateAction<UserInfo, UpswdInfo> {
	
	public UserVisiUpswdInsertAnonymous(DeciTreeOption<UserInfo> option) {
		super(option, UserInfo.class, UpswdInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UpswdInfo>> getTreeClassHook() {
		return RootUpswdInsertAnonymous.class;
	}
	
	
	
	@Override protected List<UpswdInfo> toActionClassHook(List<UserInfo> recordInfos) {
		return UpswdCopier.copyFromUser(recordInfos);
	}
	
	
	
	@Override protected List<UserInfo> toBaseClassHook(List<UserInfo> baseInfos, List<UpswdInfo> results) {
		return baseInfos;
	}
}
