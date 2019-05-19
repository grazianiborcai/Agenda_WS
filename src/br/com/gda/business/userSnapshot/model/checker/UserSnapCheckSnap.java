package br.com.gda.business.userSnapshot.model.checker;

import java.util.List;

import br.com.gda.business.snapshot_.info.SnapInfo;
import br.com.gda.business.snapshot_.model.checker.SnapCheckExist;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class UserSnapCheckSnap implements ModelChecker<UserSnapInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<SnapInfo> checker;
	
	
	public UserSnapCheckSnap(ModelCheckerOption option) {
		checker = new SnapCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<UserSnapInfo> recordInfos) {
		for (UserSnapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(UserSnapInfo recordInfo) {
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
