package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker;

import br.com.mind5.business.addressSnapshot.info.AddresnapCopier;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckAddresnap extends ModelCheckerTemplateForward<CremoipInfo, AddresnapInfo> {
	
	public CremoipCheckAddresnap(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<AddresnapInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddresnapCheckExist(option);
	}
	
	
	
	@Override protected AddresnapInfo toForwardClass(CremoipInfo baseRecord) {
		return AddresnapCopier.copyFromCremoip(baseRecord);
	}
}
