package br.com.mind5.payment.countryPartner.info;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CounparMergerPaypar extends InfoMergerTemplate<CounparInfo, PayparInfo> {

	@Override protected InfoMergerVisitor<CounparInfo,  PayparInfo> getVisitorHook() {
		return new CounparVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<CounparInfo> getUniquifierHook() {
		return new CounparUniquifier();
	}
}
