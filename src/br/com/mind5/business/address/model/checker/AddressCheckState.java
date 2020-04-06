package br.com.mind5.business.address.model.checker;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.business.masterData.model.checker.StateCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class AddressCheckState extends ModelCheckerTemplateForwardV2<AddressInfo, StateInfo> {
	
	public AddressCheckState(ModelCheckerOption option) {
		super(option);
	}

	

	@Override protected ModelCheckerV1<StateInfo> getCheckerHook(ModelCheckerOption option) {
		return new StateCheckExist(option);
	}
	
	
	
	@Override protected StateInfo toForwardClass(AddressInfo baseRecord) {
		return StateInfo.copyFrom(baseRecord);
	}
}
