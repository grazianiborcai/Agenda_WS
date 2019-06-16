package br.com.gda.payment.ownerPartner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.countryPartner.info.CounparInfo;

final class OwnparMergerCounpar extends InfoMergerTemplate<OwnparInfo, CounparInfo> {

	@Override protected InfoMergerVisitorV2<OwnparInfo, CounparInfo> getVisitorHook() {
		return new OwnparVisiMergeCounpar();
	}
	
	
	
	@Override protected InfoUniquifier<OwnparInfo> getUniquifierHook() {
		return new OwnparUniquifier();
	}
}
