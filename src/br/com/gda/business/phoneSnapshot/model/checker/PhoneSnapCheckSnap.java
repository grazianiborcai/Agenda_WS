package br.com.gda.business.phoneSnapshot.model.checker;

import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.business.snapshot_.info.SnapInfo;
import br.com.gda.business.snapshot_.model.checker.SnapCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class PhoneSnapCheckSnap implements ModelChecker<PhoneSnapInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<SnapInfo> checker;
	
	
	public PhoneSnapCheckSnap(ModelCheckerOption option) {
		checker = new SnapCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PhoneSnapInfo> recordInfos) {
		for (PhoneSnapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PhoneSnapInfo recordInfo) {
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
