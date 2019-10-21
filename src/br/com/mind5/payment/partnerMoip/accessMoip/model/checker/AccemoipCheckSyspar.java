package br.com.mind5.payment.partnerMoip.accessMoip.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.mind5.payment.systemPartner.model.checker.SysparCheckExist;

public final class AccemoipCheckSyspar implements ModelChecker<AccemoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<SysparInfo> checker;
	
	
	public AccemoipCheckSyspar(ModelCheckerOption option) {
		checker = new SysparCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<AccemoipInfo> recordInfos) {
		for (AccemoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(AccemoipInfo recordInfo) {
		return checker.check(SysparInfo.copyFrom(recordInfo));
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
