package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.business.addressSnapshot.info.AddresnapCopier;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckAddresnap extends ModelCheckerTemplateForward<CusparInfo, AddresnapInfo> {
	
	public CusparCheckAddresnap(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<AddresnapInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddresnapCheckExist(option);
	}
	
	
	
	@Override protected AddresnapInfo toForwardClass(CusparInfo baseRecord) {
		return AddresnapCopier.copyFromCuspar(baseRecord);
	}
}
