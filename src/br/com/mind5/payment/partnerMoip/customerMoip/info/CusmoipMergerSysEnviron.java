package br.com.mind5.payment.partnerMoip.customerMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CusmoipMergerSysEnviron extends InfoMergerTemplate<CusmoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor<CusmoipInfo, SysEnvironInfo> getVisitorHook() {
		return new CusmoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<CusmoipInfo> getUniquifierHook() {
		return new CusmoipUniquifier();
	}
}
