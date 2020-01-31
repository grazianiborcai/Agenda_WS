package br.com.mind5.payment.partnerMoip.customerMoip.info;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CusmoipMergerSysEnviron extends InfoMergerTemplate_<CusmoipInfo, SysEnvironInfo> {

	@Override protected InfoMergerVisitor_<CusmoipInfo, SysEnvironInfo> getVisitorHook() {
		return new CusmoipVisiMergeSysEnviron();
	}
	
	
	
	@Override protected InfoUniquifier<CusmoipInfo> getUniquifierHook() {
		return new CusmoipUniquifier();
	}
}
