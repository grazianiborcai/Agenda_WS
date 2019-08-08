package br.com.gda.payment.partnerMoip.accessMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.systemPartner.info.SysparInfo;

final class AccemoipMergerSyspar extends InfoMergerTemplate<AccemoipInfo, SysparInfo> {

	@Override protected InfoMergerVisitor<AccemoipInfo, SysparInfo> getVisitorHook() {
		return new AccemoipVisiMergeSyspar();
	}
	
	
	
	@Override protected InfoUniquifier<AccemoipInfo> getUniquifierHook() {
		return new AccemoipUniquifier();
	}
}
