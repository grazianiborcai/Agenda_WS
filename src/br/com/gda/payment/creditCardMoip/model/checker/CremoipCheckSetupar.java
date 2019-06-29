package br.com.gda.payment.creditCardMoip.model.checker;

import java.util.List;

import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payment.creditCardMoip.info.CremoipInfo;
import br.com.gda.payment.setupPartner.info.SetuparCopier;
import br.com.gda.payment.setupPartner.info.SetuparInfo;
import br.com.gda.payment.setupPartner.model.checker.SetuparCheckExist;

public final class CremoipCheckSetupar implements ModelChecker<CremoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<SetuparInfo> checker;
	
	
	public CremoipCheckSetupar(ModelCheckerOption option) {
		checker = new SetuparCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CremoipInfo> recordInfos) {
		for (CremoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CremoipInfo recordInfo) {
		return checker.check(SetuparCopier.copyFromCremoip(recordInfo));
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
