package br.com.gda.business.ownerStore.model.checker;

import java.util.List;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.business.store.info.StoreCopier;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.checker.StoreCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class OwntoreCheckStore implements ModelChecker<OwntoreInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StoreInfo> checker;
	
	
	public OwntoreCheckStore(ModelCheckerOption option) {
		checker = new StoreCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<OwntoreInfo> recordInfos) {
		for (OwntoreInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(OwntoreInfo recordInfo) {
		return checker.check(StoreCopier.copyFromOwntore(recordInfo));
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
