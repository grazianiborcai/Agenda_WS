package br.com.mind5.security.userPassword.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.model.ModelResponse;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.common.ModelResponseJwt;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.decisionTree.RootUpswdUpdateAuth;

public final class UpswdModelUpdateAuth extends ModelTemplate<UpswdInfo> {

	public UpswdModelUpdateAuth(String incomingData, HttpServletRequest request) {
		super(incomingData, request, UpswdInfo.class);
	}
	
	
	
	@Override protected DeciTree<UpswdInfo> getDecisionTreeHook(DeciTreeOption<UpswdInfo> option) {
		return new RootUpswdUpdateAuth(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
	
	
	
	@Override protected ModelResponse<UpswdInfo> getModelResponseHook() {	
		return new ModelResponseJwt<>();
	}
}
