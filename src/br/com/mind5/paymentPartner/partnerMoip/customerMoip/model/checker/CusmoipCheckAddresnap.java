package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker;

import br.com.mind5.business.addressSnapshot.info.AddresnapCopier;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

public final class CusmoipCheckAddresnap extends ModelCheckerTemplateForward<CusmoipInfo, AddresnapInfo> {
	
	public CusmoipCheckAddresnap(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<AddresnapInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddresnapCheckExist(option);
	}
	
	
	
	@Override protected AddresnapInfo toForwardClass(CusmoipInfo baseRecord) {
		return AddresnapCopier.copyFromCusmoip(baseRecord);
	}
}
