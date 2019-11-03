package br.com.mind5.security.user.model;

import javax.servlet.http.HttpServletRequest;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserUpdate;

public final class UserModelUpdate extends ModelTemplate<UserInfo> {

	public UserModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, UserInfo.class);
	}
	
	
	
	@Override protected DeciTree<UserInfo> getDecisionTreeHook(DeciTreeOption<UserInfo> option) {
		return new RootUserUpdate(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
