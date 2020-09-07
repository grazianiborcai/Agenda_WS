package br.com.mind5.business.address.model.checker;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressDefault.model.checker.AddaultCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class AddressCheckAddault extends ModelCheckerTemplateForwardV2<AddressInfo, AddaultInfo> {
	
	public AddressCheckAddault(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<AddaultInfo> getCheckerHook(ModelCheckerOption option) {
		return new AddaultCheckExist(option);
	}
	
	
	
	@Override protected AddaultInfo toForwardClass(AddressInfo baseRecord) {
		return AddaultInfo.copyFrom(baseRecord);
	}
}
