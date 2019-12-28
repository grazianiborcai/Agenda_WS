package br.com.mind5.business.customer.model.checker;

import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchCopier;
import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.checker.AddarchCheckExist;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class CusCheckAddarch implements ModelChecker<CusInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<AddarchInfo> checker;
	
	
	public CusCheckAddarch(ModelCheckerOption option) {
		checker = new AddarchCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CusInfo> recordInfos) {
		for (CusInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(CusInfo recordInfo) {
		return checker.check(AddarchCopier.copyFromCusKey(recordInfo));
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
