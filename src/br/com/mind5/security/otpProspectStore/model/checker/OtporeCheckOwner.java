package br.com.mind5.security.otpProspectStore.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public final class OtporeCheckOwner extends ModelCheckerTemplateForward<OtporeInfo, OwnerInfo> {
	
	public OtporeCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(OtporeInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
