package br.com.mind5.business.phone.model.checker;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.business.phoneDefault.model.checker.PhonaultCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class PhoneCheckPhonault extends ModelCheckerTemplateForward<PhoneInfo, PhonaultInfo> {
	
	public PhoneCheckPhonault(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PhonaultInfo> getCheckerHook(ModelCheckerOption option) {
		return new PhonaultCheckExist(option);
	}
	
	
	
	@Override protected PhonaultInfo toForwardClass(PhoneInfo baseRecord) {
		return PhonaultInfo.copyFrom(baseRecord);
	}
}
