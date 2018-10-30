package br.com.gda.business.address.model.checker;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.masterData.info.StateInfo;
import br.com.gda.business.masterData.model.checker.StateCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class AddressCheckState implements ModelChecker<AddressInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StateInfo> checker;
	
	
	public AddressCheckState(ModelCheckerOption option) {
		checker = new StateCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<AddressInfo> recordInfos) {
		for (AddressInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(AddressInfo recordInfo) {
		return checker.check(StateInfo.copyFrom(recordInfo));
	}

	
	
	@Override public boolean getResult() {
		return checker.getResult();
	}

	
	
	@Override public String getFailMessage() {
		return checker.getFailMessage();
	}

	
	
	@Override public int getFailCode() {
		return checker.getFailCode();
	}
}
