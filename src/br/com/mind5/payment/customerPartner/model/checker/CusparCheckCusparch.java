package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchCopier;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.model.checker.CusparchCheckExist;

public final class CusparCheckCusparch extends ModelCheckerTemplateForwardV2<CusparInfo, CusparchInfo> {
	
	public CusparCheckCusparch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CusparchInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusparchCheckExist(option);
	}
	
	
	
	@Override protected CusparchInfo toForwardClass(CusparInfo baseRecord) {
		return CusparchCopier.copyFromCuspar(baseRecord);
	}
}
