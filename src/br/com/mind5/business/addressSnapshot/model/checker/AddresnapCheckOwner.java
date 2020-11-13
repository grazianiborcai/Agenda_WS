package br.com.mind5.business.addressSnapshot.model.checker;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class AddresnapCheckOwner extends ModelCheckerTemplateForward<AddresnapInfo, OwnerInfo> {
	
	public AddresnapCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(AddresnapInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
