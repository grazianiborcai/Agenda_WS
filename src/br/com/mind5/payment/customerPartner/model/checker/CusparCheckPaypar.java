package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.business.masterData.model.checker.PayparCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckPaypar extends ModelCheckerTemplateForwardV2<CusparInfo, PayparInfo> {
	
	public CusparCheckPaypar(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<PayparInfo> getCheckerHook(ModelCheckerOption option) {
		return new PayparCheckExist(option);
	}
	
	
	
	@Override protected PayparInfo toForwardClass(CusparInfo baseRecord) {
		return PayparInfo.copyFrom(baseRecord);
	}
}
