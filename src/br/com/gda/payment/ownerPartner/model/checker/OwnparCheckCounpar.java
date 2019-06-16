package br.com.gda.payment.ownerPartner.model.checker;

import java.util.List;

import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payment.countryPartner.info.CounparInfo;
import br.com.gda.payment.countryPartner.model.checker.CounparCheckExist;
import br.com.gda.payment.ownerPartner.info.OwnparInfo;

public final class OwnparCheckCounpar implements ModelChecker<OwnparInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<CounparInfo> checker;
	
	
	public OwnparCheckCounpar(ModelCheckerOption option) {
		checker = new CounparCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<OwnparInfo> recordInfos) {
		for (OwnparInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(OwnparInfo recordInfo) {
		return checker.check(CounparInfo.copyFrom(recordInfo));
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
