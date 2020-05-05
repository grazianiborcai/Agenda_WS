package br.com.mind5.payment.creditCard.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCardSearch.info.CrecarchCopier;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.model.checker.CrecarchCheckExist;

public final class CrecardCheckCrecarch extends ModelCheckerTemplateForwardV2<CrecardInfo, CrecarchInfo> {
	
	public CrecardCheckCrecarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CrecarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new CrecarchCheckExist(option);
	}
	
	
	
	@Override protected CrecarchInfo toForwardClass(CrecardInfo baseRecord) {
		return CrecarchCopier.copyFromCrecard(baseRecord);
	}
}
