package br.com.mind5.business.scheduleLine.model.checker;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.checker.CusCheckExist;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class SchedineCheckCus implements ModelChecker<SchedineInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<CusInfo> checker;
	
	
	public SchedineCheckCus(ModelCheckerOption option) {
		checker = new CusCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<SchedineInfo> recordInfos) {
		for (SchedineInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(SchedineInfo recordInfo) {
		return checker.check(CusInfo.copyFrom(recordInfo));
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
