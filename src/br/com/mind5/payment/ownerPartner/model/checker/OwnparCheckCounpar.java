package br.com.mind5.payment.ownerPartner.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.model.checker.CounparCheckExist;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

public final class OwnparCheckCounpar extends ModelCheckerTemplateForward<OwnparInfo, CounparInfo> {
	
	public OwnparCheckCounpar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CounparInfo> getCheckerHook(ModelCheckerOption option) {
		return new CounparCheckExist(option);
	}
	
	
	
	@Override protected CounparInfo toForwardClass(OwnparInfo baseRecord) {
		return CounparInfo.copyFrom(baseRecord);
	}
}
