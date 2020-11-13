package br.com.mind5.business.address.model.checker;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class AddressCheckOwner extends ModelCheckerTemplateForward<AddressInfo, OwnerInfo> {
	
	public AddressCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(AddressInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
