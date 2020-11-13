package br.com.mind5.business.owner.model.checker;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.checker.AddressCheckExist;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class OwnerCheckAddress extends ModelCheckerTemplateForward<OwnerInfo, AddressInfo> {
	
	public OwnerCheckAddress(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<AddressInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddressCheckExist(option);
	}
	
	
	
	@Override protected AddressInfo toForwardClass(OwnerInfo baseRecord) {
		return AddressInfo.copyFrom(baseRecord);
	}
}
