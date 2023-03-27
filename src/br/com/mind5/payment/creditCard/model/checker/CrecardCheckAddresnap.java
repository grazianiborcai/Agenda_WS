package br.com.mind5.payment.creditCard.model.checker;

import br.com.mind5.business.addressSnapshot.info.AddresnapCopier;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckAddresnap extends ModelCheckerTemplateForward<CrecardInfo, AddresnapInfo> {
	
	public CrecardCheckAddresnap(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<AddresnapInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddresnapCheckExist(option);
	}
	
	
	
	@Override protected AddresnapInfo toForwardClass(CrecardInfo baseRecord) {
		return AddresnapCopier.copyFromCrecard(baseRecord);
	}
}
