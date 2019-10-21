package br.com.mind5.business.store.model.checker;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckHasItem_;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class StoreCheckHasStolate implements ModelChecker<StoreInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StolateInfo> checker;
	
	
	public StoreCheckHasStolate(ModelCheckerOption option) {
		checker = new StolateCheckHasItem_(option);
	}
	
	
	
	@Override public boolean check(List<StoreInfo> recordInfos) {
		for (StoreInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StoreInfo recordInfo) {
		return checker.check(StolateInfo.copyFrom(recordInfo));
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
