package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.model.checker.CusparchCheckExistUser;

public final class CusparCheckCusparch extends ModelCheckerTemplateForward<CusparInfo, CusparchInfo> {
	
	public CusparCheckCusparch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CusparchInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusparchCheckExistUser(option);
	}
	
	
	
	@Override protected CusparchInfo toForwardClass(CusparInfo baseRecord) {
		return CusparchInfo.copyFrom(baseRecord);
	}
}
