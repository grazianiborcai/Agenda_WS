package br.com.mind5.business.storeProspect.model.checker;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.config.sysStoreSignup.model.checker.SysotupCheckEnabled;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class StoprosCheckSysotup extends ModelCheckerTemplateForward<StoprosInfo, SysotupInfo> {
	
	public StoprosCheckSysotup(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SysotupInfo> getCheckerHook(ModelCheckerOption option) {
		return new SysotupCheckEnabled(option);
	}
	
	
	
	@Override protected SysotupInfo toForwardClass(StoprosInfo baseRecord) {
		return SysotupInfo.copyFrom(baseRecord);
	}
}
