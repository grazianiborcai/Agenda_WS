package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.business.phone.info.PhoneCopier;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.checker.PhoneCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckPhone extends ModelCheckerTemplateForward<CusparInfo, PhoneInfo> {
	
	public CusparCheckPhone(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PhoneInfo> getCheckerHook(ModelCheckerOption option) {
		return new PhoneCheckExist(option);
	}
	
	
	
	@Override protected PhoneInfo toForwardClass(CusparInfo baseRecord) {
		return PhoneCopier.copyFromCuspar(baseRecord);
	}
}
