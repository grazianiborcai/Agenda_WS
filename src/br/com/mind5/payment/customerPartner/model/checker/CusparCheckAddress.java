package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.checker.AddressCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckAddress extends ModelCheckerTemplateForwardV2<CusparInfo, AddressInfo> {
	
	public CusparCheckAddress(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<AddressInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddressCheckExist(option);
	}
	
	
	
	@Override protected AddressInfo toForwardClass(CusparInfo baseRecord) {
		return AddressCopier.copyFromCuspar(baseRecord);
	}
}
