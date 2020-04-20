package br.com.mind5.payment.payOrderSearch.model.checker;

import java.util.List;

import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

public final class PayordarchCheckLangu implements ModelCheckerV1<PayordarchInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelCheckerV1<LanguInfo> checker;
	
	
	public PayordarchCheckLangu(ModelCheckerOption option) {
		checker = new LanguCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PayordarchInfo> recordInfos) {
		for (PayordarchInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PayordarchInfo recordInfo) {
		return checker.check(LanguInfo.copyFrom(recordInfo));
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
