package br.com.mind5.security.otpProspectStore.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.model.decisionTree.OtporeRootInsert;

public final class OtporeModelInsert extends ModelTemplate<OtporeInfo> {

	public OtporeModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, OtporeInfo.class);
	}
	
	
	
	@Override protected DeciTree<OtporeInfo> getDecisionTreeHook(DeciTreeOption<OtporeInfo> option) {
		return new OtporeRootInsert(option);
	}
}
