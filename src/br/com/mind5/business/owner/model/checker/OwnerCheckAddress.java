package br.com.mind5.business.owner.model.checker;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.checker.AddressCheckExist;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class OwnerCheckAddress extends ModelCheckerTemplateForwardV2<OwnerInfo, AddressInfo> {
	
	public OwnerCheckAddress(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<AddressInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddressCheckExist(option);
	}
	
	
	
	@Override protected AddressInfo toForwardClass(OwnerInfo baseRecord) {
		return AddressInfo.copyFrom(baseRecord);
	}
}
