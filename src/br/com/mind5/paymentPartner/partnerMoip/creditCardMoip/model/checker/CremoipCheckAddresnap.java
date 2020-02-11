package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapCopier;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckAddresnap implements ModelChecker<CremoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<AddresnapInfo> checker;
	
	
	public CremoipCheckAddresnap(ModelCheckerOption option) {
		checker = new AddresnapCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CremoipInfo> recordInfos) {
		for (CremoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CremoipInfo recordInfo) {
		return checker.check(AddresnapCopier.copyFromCremoip(recordInfo));
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
