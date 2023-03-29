package br.com.mind5.payment.refundOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;

final class RefemMergerVisiOrdapa extends InfoMergerVisitorTemplate<RefemInfo, OrdapaInfo> {

	@Override public boolean shouldMerge(RefemInfo baseInfo, OrdapaInfo selectedInfo) {
		return (baseInfo.codOwner        == selectedInfo.codOwner    &&
				baseInfo.codPayOrder     == selectedInfo.codPayOrder &&
				baseInfo.codPayOrderItem == selectedInfo.codPayOrderItem);
	}
	
	
	
	@Override public List<RefemInfo> merge(RefemInfo baseInfo, OrdapaInfo selectedInfo) {
		List<RefemInfo> results = new ArrayList<>();
		
		baseInfo = setCharge(baseInfo, selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private RefemInfo setCharge(RefemInfo baseInfo, OrdapaInfo selectedInfo) {
		if (selectedInfo.responseTransaction == null)
			return baseInfo;
			
		baseInfo.idRefundPartner     = selectedInfo.responseTransaction.get("id");
		baseInfo.statusRefundPartner = selectedInfo.responseTransaction.get("status");	
		
		return baseInfo;
	}
}
