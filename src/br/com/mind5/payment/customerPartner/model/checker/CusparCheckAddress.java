package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.checker.AddressCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckAddress extends ModelCheckerTemplateForward<CusparInfo, AddressInfo> {
	
	public CusparCheckAddress(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<AddressInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddressCheckExist(option);
	}
	
	
	
	@Override protected AddressInfo toForwardClass(CusparInfo baseRecord) {
		return AddressCopier.copyFromCuspar(baseRecord);
	}
}
