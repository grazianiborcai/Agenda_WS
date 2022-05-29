package br.com.mind5.security.user.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.UserRootSignup;

public final class UserModelSignup extends ModelTemplate<UserInfo> {

	public UserModelSignup(String incomingData, HttpServletRequest request) {
		super(incomingData, request, UserInfo.class);
	}
	
	
	
	@Override protected DeciTree<UserInfo> getDecisionTreeHook(DeciTreeOption<UserInfo> option) {
		return new UserRootSignup(option);
	}
}
