package br.com.mind5.business.storeProspect.info;

import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.config.sysStoreSignup.model.checker.SysotupCheckEnabled;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StoprosCheckSysotup extends ModelCheckerTemplateForwardV2<StoprosInfo, SysotupInfo> {
	
	public StoprosCheckSysotup(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SysotupInfo> getCheckerHook(ModelCheckerOption option) {
		return new SysotupCheckEnabled(option);
	}
	
	
	
	@Override protected SysotupInfo toForwardClass(StoprosInfo baseRecord) {
		return SysotupInfo.copyFrom(baseRecord);
	}
}
