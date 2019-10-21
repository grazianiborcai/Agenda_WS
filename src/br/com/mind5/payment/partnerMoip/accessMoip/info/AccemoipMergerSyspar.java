package br.com.mind5.payment.partnerMoip.accessMoip.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

final class AccemoipMergerSyspar extends InfoMergerTemplate<AccemoipInfo, SysparInfo> {

	@Override protected InfoMergerVisitor<AccemoipInfo, SysparInfo> getVisitorHook() {
		return new AccemoipVisiMergeSyspar();
	}
	
	
	
	@Override protected InfoUniquifier<AccemoipInfo> getUniquifierHook() {
		return new AccemoipUniquifier();
	}
}
