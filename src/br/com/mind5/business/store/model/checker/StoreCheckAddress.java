package br.com.mind5.business.store.model.checker;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.checker.AddressCheckExist;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StoreCheckAddress extends ModelCheckerTemplateForwardV2<StoreInfo, AddressInfo> {
	
	public StoreCheckAddress(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<AddressInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddressCheckExist(option);
	}
	
	
	
	@Override protected AddressInfo toForwardClass(StoreInfo baseRecord) {
		return AddressInfo.copyFrom(baseRecord);
	}
}
