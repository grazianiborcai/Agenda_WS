package br.com.mind5.business.scheduleLineSnapshot.model.checker;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class SchedinapCheckOwner implements ModelChecker<SchedinapInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<OwnerInfo> checker;
	
	
	public SchedinapCheckOwner(ModelCheckerOption option) {
		checker = new OwnerCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<SchedinapInfo> recordInfos) {
		for (SchedinapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(SchedinapInfo recordInfo) {
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
