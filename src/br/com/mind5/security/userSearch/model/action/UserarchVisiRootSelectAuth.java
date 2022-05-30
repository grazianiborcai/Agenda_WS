package br.com.mind5.security.userSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.decisionTree.UserarchRootSelectAuth;

public final class UserarchVisiRootSelectAuth extends ActionVisitorTemplateAction<UserarchInfo, UserarchInfo> {

	public UserarchVisiRootSelectAuth(DeciTreeOption<UserarchInfo> option) {
		super(option, UserarchInfo.class, UserarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserarchInfo>> getTreeClassHook() {
		return UserarchRootSelectAuth.class;
	}
	
	
	
	@Override protected List<UserarchInfo> toBaseClassHook(List<UserarchInfo> baseInfos, List<UserarchInfo> results) {
		return results;
	}
}
