package br.com.mind5.payment.statusPayOrder.info;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;

final class PaytusMergerVisiOrdapa extends InfoMergerVisitorTemplate<PaytusInfo, OrdapaInfo> {

	@Override public boolean shouldMerge(PaytusInfo baseInfo, OrdapaInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner	 &&
				baseInfo.codPayOrder == selectedInfo.codPayOrder	);
	}
	
	
	
	@Override public List<PaytusInfo> merge(PaytusInfo baseInfo, OrdapaInfo selectedInfo) {
		List<PaytusInfo> results = new ArrayList<>();
		
		baseInfo = setHeaderAttr(baseInfo, selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private PaytusInfo setHeaderAttr(PaytusInfo baseInfo, OrdapaInfo selectedInfo) {		
		baseInfo = setHeaderAttrRoot(baseInfo, selectedInfo);
		baseInfo = setHeaderAttrCharges(baseInfo, selectedInfo);
		
		return baseInfo;
	}
	
	
	
	private PaytusInfo setHeaderAttrRoot(PaytusInfo baseInfo, OrdapaInfo selectedInfo) {
		if (selectedInfo.responseRoot == null)
			return baseInfo;
		
		baseInfo.idOrderPartner        = selectedInfo.responseRoot.get("id");
		baseInfo.statusOrderPartner    = selectedInfo.responseRoot.get("status");
		baseInfo.amountTotalPartner    = selectedInfo.responseRoot.get("amount");
		baseInfo.amountCurrencyPartner = selectedInfo.responseRoot.get("currency");
		
		return baseInfo;
	}
	
	
	
	private PaytusInfo setHeaderAttrCharges(PaytusInfo baseInfo, OrdapaInfo selectedInfo) {
		if (selectedInfo.responseCharges == null)
			return baseInfo;
		
		if (selectedInfo.responseCharges.isEmpty())
			return baseInfo;
		
		Map<String, String> charge = selectedInfo.responseCharges.get(0);
		
		baseInfo.idPaymentPartner     = charge.get("charge_id");
		baseInfo.statusPaymentPartner = charge.get("transaction_status");
		
		return baseInfo;
	}
	
	
	
	@Override public List<PaytusInfo> uniquifyHook(List<PaytusInfo> results) {
		InfoUniquifier<PaytusInfo> uniquifier = new PaytusUniquifier();		
		return uniquifier.uniquify(results);
	}
}
