package br.com.mind5.security.otpProspectStore.model.checker;

import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.config.sysStoreSignup.model.checker.SysotupCheckEnabled;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public final class OtporeCheckSysotup extends ModelCheckerTemplateForward<OtporeInfo, SysotupInfo> {
	
	public OtporeCheckSysotup(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SysotupInfo> getCheckerHook(ModelCheckerOption option) {
		return new SysotupCheckEnabled(option);
	}
	
	
	
	@Override protected SysotupInfo toForwardClass(OtporeInfo baseRecord) {
		return SysotupInfo.copyFrom(baseRecord);
	}
}
