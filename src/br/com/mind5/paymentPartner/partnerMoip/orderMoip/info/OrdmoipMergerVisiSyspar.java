package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

final class OrdmoipMergerVisiSyspar extends InfoMergerVisitorTemplate<OrdmoipInfo, SysparInfo> {

	@Override public boolean shouldMerge(OrdmoipInfo baseInfo, SysparInfo selectedInfo) {
		return (baseInfo.cusparData.codPayPartner == selectedInfo.codPayPartner);
	}
	
	
	
	@Override public List<OrdmoipInfo> merge(OrdmoipInfo baseInfo, SysparInfo selectedInfo) {
		List<OrdmoipInfo> results = new ArrayList<>();
		
		baseInfo.sysparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
