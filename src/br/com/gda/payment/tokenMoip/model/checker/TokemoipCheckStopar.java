package br.com.gda.payment.tokenMoip.model.checker;

import java.util.List;

import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.model.checker.StoparCheckExist;
import br.com.gda.payment.tokenMoip.info.TokemoipInfo;

public final class TokemoipCheckStopar implements ModelChecker<TokemoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StoparInfo> checker;
	
	
	public TokemoipCheckStopar(ModelCheckerOption option) {
		checker = new StoparCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<TokemoipInfo> recordInfos) {
		for (TokemoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(TokemoipInfo recordInfo) {
		return checker.check(StoparInfo.copyFrom(recordInfo));
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
