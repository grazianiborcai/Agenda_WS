package br.com.mind5.business.address.model.checker;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressDefault.model.checker.AddaultCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class AddressCheckAddault extends ModelCheckerTemplateForward<AddressInfo, AddaultInfo> {
	
	public AddressCheckAddault(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<AddaultInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddaultCheckExist(option);
	}
	
	
	
	@Override protected AddaultInfo toForwardClass(AddressInfo baseRecord) {
		return AddaultInfo.copyFrom(baseRecord);
	}
}
