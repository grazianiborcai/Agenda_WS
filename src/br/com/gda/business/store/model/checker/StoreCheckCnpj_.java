package br.com.gda.business.store.model.checker;

import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.common.ModelCheckerCnpj_;

public final class StoreCheckCnpj_ implements ModelChecker<StoreInfo> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;
	
	private ModelChecker<String> checkerCnpj;
	
	public StoreCheckCnpj_() {
		checkerCnpj = new ModelCheckerCnpj_();
	}

	
	
	@Override public boolean check(List<StoreInfo> recordInfos) {
		for (StoreInfo eachStoreInfo : recordInfos) {
			if (check(eachStoreInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StoreInfo recordInfo) {
		return checkerCnpj.check(recordInfo.cnpj);
	}

	
	
	@Override public boolean getResult() {
		return checkerCnpj.getResult();
	}

	
	
	@Override public String getFailMessage() {
		return checkerCnpj.getFailMessage();
	}

	
	
	@Override public int getFailCode() {
		return checkerCnpj.getFailCode();
	}
}
