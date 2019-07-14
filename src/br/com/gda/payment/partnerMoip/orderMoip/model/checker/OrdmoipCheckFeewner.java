package br.com.gda.payment.partnerMoip.orderMoip.model.checker;

import java.util.List;

import br.com.gda.business.feeOwner.info.FeewnerInfo;
import br.com.gda.business.feeOwner.model.checker.FeewnerCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class OrdmoipCheckFeewner implements ModelChecker<OrdmoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<FeewnerInfo> checker;
	
	
	public OrdmoipCheckFeewner(ModelCheckerOption option) {
		checker = new FeewnerCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<OrdmoipInfo> recordInfos) {
		for (OrdmoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(OrdmoipInfo recordInfo) {
		return checker.check(recordInfo.feewnerData);
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
