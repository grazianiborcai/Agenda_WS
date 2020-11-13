package br.com.mind5.business.addressSnapshot.model.checker;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.checker.AddressCheckExist;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class AddresnapCheckAddress extends ModelCheckerTemplateForward<AddresnapInfo, AddressInfo> {
	
	public AddresnapCheckAddress(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<AddressInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddressCheckExist(option);
	}
	
	
	
	@Override protected AddressInfo toForwardClass(AddresnapInfo baseRecord) {
		return AddressInfo.copyFrom(baseRecord);
	}
}
