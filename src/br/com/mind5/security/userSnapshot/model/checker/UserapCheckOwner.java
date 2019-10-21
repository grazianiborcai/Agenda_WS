package br.com.mind5.security.userSnapshot.model.checker;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class UserapCheckOwner implements ModelChecker<UserapInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<OwnerInfo> checker;
	
	
	public UserapCheckOwner(ModelCheckerOption option) {
		checker = new OwnerCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<UserapInfo> recordInfos) {
		for (UserapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(UserapInfo recordInfo) {
		return checker.check(OwnerInfo.copyFrom(recordInfo));
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
