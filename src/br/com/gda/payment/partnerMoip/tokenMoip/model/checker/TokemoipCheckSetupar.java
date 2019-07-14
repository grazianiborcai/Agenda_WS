package br.com.gda.payment.partnerMoip.tokenMoip.model.checker;

import java.util.List;

import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payment.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.gda.payment.setupPartner.info.SetuparInfo;
import br.com.gda.payment.setupPartner.model.checker.SetuparCheckExist;

public final class TokemoipCheckSetupar implements ModelChecker<TokemoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<SetuparInfo> checker;
	
	
	public TokemoipCheckSetupar(ModelCheckerOption option) {
		checker = new SetuparCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<TokemoipInfo> recordInfos) {
		for (TokemoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(TokemoipInfo recordInfo) {
		return checker.check(SetuparInfo.copyFrom(recordInfo));
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
