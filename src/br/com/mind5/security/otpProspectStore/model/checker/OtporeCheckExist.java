package br.com.mind5.security.otpProspectStore.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.model.action.StdOtporeDaoSelect;

public final class OtporeCheckExist extends ModelCheckerTemplateActionV2<OtporeInfo, OtporeInfo> {
	
	public OtporeCheckExist(ModelCheckerOption option) {
		super(option, OtporeInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<OtporeInfo> buildActionHook(DeciTreeOption<OtporeInfo> option) {
		ActionStdV1<OtporeInfo> select = new StdOtporeDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.OTP_PROSP_STORE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.OTP_PROSP_STORE_NOT_FOUND;
	}
}
