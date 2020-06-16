package br.com.mind5.security.otpUserPassword.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.model.decisionTree.RootOtperasInsert;

public final class OtperasModelInsert extends ModelTemplate<OtperasInfo> {

	public OtperasModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, OtperasInfo.class);
	}
	
	
	
	@Override protected DeciTree<OtperasInfo> getDecisionTreeHook(DeciTreeOption<OtperasInfo> option) {
		return new RootOtperasInsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
