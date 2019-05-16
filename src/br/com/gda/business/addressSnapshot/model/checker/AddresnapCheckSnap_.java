package br.com.gda.business.addressSnapshot.model.checker;

import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.business.snapshot.model.checker.SnapCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class AddresnapCheckSnap_ implements ModelChecker<AddresnapInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<SnapInfo> checker;
	
	
	public AddresnapCheckSnap_(ModelCheckerOption option) {
		checker = new SnapCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<AddresnapInfo> recordInfos) {
		for (AddresnapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(AddresnapInfo recordInfo) {
		return checker.check(SnapInfo.copyFrom(recordInfo));
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
