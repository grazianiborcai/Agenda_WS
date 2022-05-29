package br.com.mind5.security.user.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.UserRootDeleteAuth;

public final class UserModelDeleteAuth extends ModelTemplate<UserInfo> {

	public UserModelDeleteAuth(UserInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<UserInfo> getDecisionTreeHook(DeciTreeOption<UserInfo> option) {
		return new UserRootDeleteAuth(option);
	}
}
