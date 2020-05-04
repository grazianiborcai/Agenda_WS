package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.security.userSnapshot.info.UserapCopier;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.model.checker.UserapCheckExist;

public final class CusmoipCheckUserap extends ModelCheckerTemplateForwardV2<CusmoipInfo, UserapInfo> {
	
	public CusmoipCheckUserap(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UserapInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserapCheckExist(option);
	}
	
	
	
	@Override protected UserapInfo toForwardClass(CusmoipInfo baseRecord) {
		return UserapCopier.copyFromCusmoip(baseRecord);
	}
}
