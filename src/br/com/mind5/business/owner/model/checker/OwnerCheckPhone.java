package br.com.mind5.business.owner.model.checker;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.checker.PhoneCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class OwnerCheckPhone implements ModelChecker<OwnerInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<PhoneInfo> checker;
	
	
	public OwnerCheckPhone(ModelCheckerOption option) {
		checker = new PhoneCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<OwnerInfo> recordInfos) {
		for (OwnerInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(OwnerInfo recordInfo) {
		return checker.check(PhoneInfo.copyFrom(recordInfo));
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
