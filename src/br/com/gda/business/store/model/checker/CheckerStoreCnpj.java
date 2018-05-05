package br.com.gda.business.store.model.checker;

import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerCnpj;

public final class CheckerStoreCnpj implements ModelChecker<StoreInfo> {
	private final boolean RESULT_SUCCESS = true;
	private final boolean RESULT_FAILED = false;
	
	private ModelChecker<String> checkerCnpj;
	
	public CheckerStoreCnpj() {
		checkerCnpj = new ModelCheckerCnpj();
	}

	
	
	@Override public boolean check(List<StoreInfo> recordInfos) {
		for (StoreInfo eachStoreInfo : recordInfos) {
			if (check(eachStoreInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(StoreInfo recordInfo) {
		return checkerCnpj.check(recordInfo.cnpj);
	}

	
	
	@Override public boolean getResult() {
		return checkerCnpj.getResult();
	}

	
	
	@Override public String getFailureExplanation() {
		return checkerCnpj.getFailureExplanation();
	}

	
	
	@Override public int getFailureCode() {
		return checkerCnpj.getFailureCode();
	}
}
