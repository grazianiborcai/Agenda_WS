package br.com.mind5.payment.creditCard.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchCopier;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.model.checker.CusparchCheckExist;

public final class CrecardCheckCusparch extends ModelCheckerTemplateForwardV2<CrecardInfo, CusparchInfo> {
	
	public CrecardCheckCusparch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CusparchInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusparchCheckExist(option);
	}
	
	
	
	@Override protected CusparchInfo toForwardClass(CrecardInfo baseRecord) {
		return CusparchCopier.copyFromCrecard(baseRecord);
	}
}
