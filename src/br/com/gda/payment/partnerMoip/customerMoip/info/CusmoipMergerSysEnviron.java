package br.com.gda.payment.partnerMoip.customerMoip.info;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CusmoipMergerSysEnviron extends InfoMergerTemplate<CusmoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor<CusmoipInfo, SysEnvironInfo> getVisitorHook() {
		return new CusmoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<CusmoipInfo> getUniquifierHook() {
		return new CusmoipUniquifier();
	}
}
