package br.com.mind5.security.otpProspectStore.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public final class StdOtporeSuccess_ extends ActionStdSuccessTemplate<OtporeInfo> {
	
	public StdOtporeSuccess_(DeciTreeOption<OtporeInfo> option) {
		super(OtporeInfo.class);
	}
}
