package br.com.gda.payment.partnerMoip.orderMoip.model.checker;

import java.util.List;

import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.systemPartner.info.SysparInfo;
import br.com.gda.payment.systemPartner.model.checker.SysparCheckExist;

public final class OrdmoipCheckSyspar implements ModelChecker<OrdmoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<SysparInfo> checker;
	
	
	public OrdmoipCheckSyspar(ModelCheckerOption option) {
		checker = new SysparCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<OrdmoipInfo> recordInfos) {
		for (OrdmoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(OrdmoipInfo recordInfo) {
		return checker.check(recordInfo.sysparData);
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
