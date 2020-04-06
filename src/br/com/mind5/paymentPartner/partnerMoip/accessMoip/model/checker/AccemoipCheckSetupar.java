package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.checker.SetuparCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;

public final class AccemoipCheckSetupar implements ModelCheckerV1<AccemoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelCheckerV1<SetuparInfo> checker;
	
	
	public AccemoipCheckSetupar(ModelCheckerOption option) {
		checker = new SetuparCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<AccemoipInfo> recordInfos) {
		for (AccemoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(AccemoipInfo recordInfo) {
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
