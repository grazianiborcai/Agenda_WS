package br.com.mind5.business.owner.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.checker.PhoneCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OwnerCheckPhone extends ModelCheckerTemplateForward<OwnerInfo, PhoneInfo> {
	
	public OwnerCheckPhone(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PhoneInfo> getCheckerHook(ModelCheckerOption option) {
		return new PhoneCheckExist(option);
	}
	
	
	
	@Override protected PhoneInfo toForwardClass(OwnerInfo baseRecord) {
		return PhoneInfo.copyFrom(baseRecord);
	}
}
