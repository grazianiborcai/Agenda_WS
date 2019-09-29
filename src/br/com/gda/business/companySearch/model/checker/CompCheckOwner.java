package br.com.gda.business.companySearch.model.checker;

import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.checker.OwnerCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class CompCheckOwner implements ModelChecker<CompInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<OwnerInfo> checker;
	
	
	public CompCheckOwner(ModelCheckerOption option) {
		checker = new OwnerCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CompInfo> recordInfos) {
		for (CompInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(CompInfo recordInfo) {
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
