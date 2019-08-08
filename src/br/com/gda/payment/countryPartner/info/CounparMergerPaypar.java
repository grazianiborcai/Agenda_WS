package br.com.gda.payment.countryPartner.info;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CounparMergerPaypar extends InfoMergerTemplate<CounparInfo, PayparInfo> {

	@Override protected InfoMergerVisitor<CounparInfo,  PayparInfo> getVisitorHook() {
		return new CounparVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<CounparInfo> getUniquifierHook() {
		return new CounparUniquifier();
	}
}
