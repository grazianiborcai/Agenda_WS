package br.com.mind5.security.otpUserPassword.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

public final class OtperasCheckOwner extends ModelCheckerTemplateForward<OtperasInfo, OwnerInfo> {
	
	public OtperasCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(OtperasInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
