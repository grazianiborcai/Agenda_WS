package br.com.gda.business.customer.model.checker;

import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.business.masterData.model.checker.GenderCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class CusCheckGender implements ModelChecker<CusInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<GenderInfo> checker;
	
	
	public CusCheckGender(ModelCheckerOption option) {
		checker = new GenderCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CusInfo> recordInfos) {
		for (CusInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CusInfo recordInfo) {
		return checker.check(GenderInfo.copyFrom(recordInfo));
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
