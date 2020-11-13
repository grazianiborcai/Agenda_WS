package br.com.mind5.business.owner.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.config.sysOwnerSignup.model.checker.SysonupCheckEnabled;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OwnerCheckSysonup extends ModelCheckerTemplateForward<OwnerInfo, SysonupInfo> {
	
	public OwnerCheckSysonup(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SysonupInfo> getCheckerHook(ModelCheckerOption option) {
		return new SysonupCheckEnabled(option);
	}
	
	
	
	@Override protected SysonupInfo toForwardClass(OwnerInfo baseRecord) {
		return SysonupInfo.copyFrom(baseRecord);
	}
}
