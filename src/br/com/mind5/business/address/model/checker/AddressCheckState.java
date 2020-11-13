package br.com.mind5.business.address.model.checker;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.checker.StateCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class AddressCheckState extends ModelCheckerTemplateForward<AddressInfo, StateInfo> {
	
	public AddressCheckState(ModelCheckerOption option) {
		super(option);
	}

	

	@Override protected ModelChecker<StateInfo> getCheckerHook(ModelCheckerOption option) {
		return new StateCheckExist(option);
	}
	
	
	
	@Override protected StateInfo toForwardClass(AddressInfo baseRecord) {
		return StateInfo.copyFrom(baseRecord);
	}
}
