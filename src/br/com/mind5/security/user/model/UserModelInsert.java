package br.com.mind5.security.user.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.UserRootInsert;

public final class UserModelInsert extends ModelTemplate<UserInfo> {

	public UserModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, UserInfo.class);
	}
	
	
	
	@Override protected DeciTree<UserInfo> getDecisionTreeHook(DeciTreeOption<UserInfo> option) {
		return new UserRootInsert(option);
	}
}
