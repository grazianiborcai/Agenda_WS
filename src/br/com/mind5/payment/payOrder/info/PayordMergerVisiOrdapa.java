package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;

final class PayordMergerVisiOrdapa extends InfoMergerVisitorTemplate<PayordInfo, OrdapaInfo> {

	@Override public boolean shouldMerge(PayordInfo baseInfo, OrdapaInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner	 &&
				baseInfo.codPayOrder == selectedInfo.codPayOrder	);
	}
	
	
	
	@Override public List<PayordInfo> merge(PayordInfo baseInfo, OrdapaInfo selectedInfo) {
		List<PayordInfo> results = new ArrayList<>();
		
		baseInfo = setHeaderAttr(baseInfo, selectedInfo);
		baseInfo = setItemAttr(baseInfo, selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private PayordInfo setHeaderAttr(PayordInfo baseInfo, OrdapaInfo selectedInfo) {		
		baseInfo = setHeaderAttrRoot(baseInfo, selectedInfo);
		baseInfo = setHeaderAttrCharges(baseInfo, selectedInfo);
		
		return baseInfo;
	}
	
	
	
	private PayordInfo setHeaderAttrRoot(PayordInfo baseInfo, OrdapaInfo selectedInfo) {
		if (selectedInfo.responseRoot == null)
			return baseInfo;
		
		baseInfo.ownId 				   = selectedInfo.responseRoot.get("code");
		baseInfo.idOrderPartner        = selectedInfo.responseRoot.get("id");
		baseInfo.statusOrderPartner    = selectedInfo.responseRoot.get("status");
		baseInfo.amountTotalPartner    = selectedInfo.responseRoot.get("amount");
		baseInfo.amountCurrencyPartner = selectedInfo.responseRoot.get("currency");
		
		return baseInfo;
	}
	
	
	
	private PayordInfo setHeaderAttrCharges(PayordInfo baseInfo, OrdapaInfo selectedInfo) {
		if (selectedInfo.responseCharges == null)
			return baseInfo;
		
		if (selectedInfo.responseCharges.isEmpty())
			return baseInfo;
		
		Map<String, String> charge = selectedInfo.responseCharges.get(0);
		
		baseInfo.idPaymentPartner     = charge.get("charge_id");
		baseInfo.statusPaymentPartner = charge.get("transaction_status");		
		baseInfo.idTransactionPartner = charge.get("transaction_id");
		
		return baseInfo;
	}
	
	
	
	private PayordInfo setItemAttr(PayordInfo baseInfo, OrdapaInfo selectedInfo) {
		baseInfo = setItemAttrRoot(baseInfo, selectedInfo);
		baseInfo = setItemAttrItems(baseInfo, selectedInfo);
		
		return baseInfo;
	}
	
	
	
	private PayordInfo setItemAttrRoot(PayordInfo baseInfo, OrdapaInfo selectedInfo) {
		if (selectedInfo.responseRoot == null)
			return baseInfo;
		
		for (PayordemInfo eachPayordem : baseInfo.payordems) {
			eachPayordem.statusOrderPartner = selectedInfo.responseRoot.get("status");
		}
		
		return baseInfo;
	}
	
	
	
	private PayordInfo setItemAttrItems(PayordInfo baseInfo, OrdapaInfo selectedInfo) {
		if (selectedInfo.items == null)
			return baseInfo;
		
		if (selectedInfo.items.isEmpty())
			return baseInfo;
		
		
		for(Map<String,String> eachItem : selectedInfo.responseItems) {
			String payItemCode = eachItem.get("code");
			
			if (payItemCode == null)
				payItemCode = "null";
			
			
			for (PayordemInfo eachPayordem : baseInfo.payordems) {
				String itemCode = eachPayordem.codOwner + "-" + eachPayordem.codPayOrder + "-" + eachPayordem.codPayOrderItem;
				
				if (payItemCode.equals(itemCode)) {
					eachPayordem.ownId                = eachItem.get("code");
					eachPayordem.idItemPartner        = eachItem.get("id");
					eachPayordem.idOrderPartner       = null;
					eachPayordem.idPaymentPartner     = null;
					eachPayordem.statusPaymentPartner = null;
				}
			}
		}
		
		return baseInfo;
	}
	
	
	
	@Override public List<PayordInfo> uniquifyHook(List<PayordInfo> results) {
		InfoUniquifier<PayordInfo> uniquifier = new PayordUniquifier();		
		return uniquifier.uniquify(results);
	}
}
