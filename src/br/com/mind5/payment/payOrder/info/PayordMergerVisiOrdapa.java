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
		baseInfo = setStatusOrder(baseInfo);
		baseInfo = setStatusPayment(baseInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private PayordInfo setHeaderAttr(PayordInfo baseInfo, OrdapaInfo selectedInfo) {
		baseInfo.amountTotalPartner    = selectedInfo.responseRoot.get("amount");
		baseInfo.amountCurrencyPartner = selectedInfo.responseRoot.get("currency");
		
		return baseInfo;
	}
	
	
	
	private PayordInfo setItemAttr(PayordInfo baseInfo, OrdapaInfo selectedInfo) {
		if (hasResponseItems(selectedInfo) == false)
			return baseInfo;
		
		
		for(Map<String,String> eachItem : selectedInfo.responseItems) {
			String payItemCode = getCode(eachItem);			
			
			for (PayordemInfo eachPayordem : baseInfo.payordems) {
				String itemCode = eachPayordem.codOwner + "-" + eachPayordem.codPayOrder + "-" + eachPayordem.codPayOrderItem;
				
				if (payItemCode.equals(itemCode)) {
					eachPayordem.ownId                = eachItem.get("code");
					eachPayordem.idItemPartner        = eachItem.get("id");
					eachPayordem.idOrderPartner       = selectedInfo.responseRoot.get("id");
					eachPayordem.idPaymentPartner     = selectedInfo.responseCharges.get(0).get("charge_id");
					eachPayordem.statusOrderPartner   = selectedInfo.responseRoot.get("status");
					eachPayordem.statusPaymentPartner = selectedInfo.responseCharges.get(0).get("transaction_status");
				}
			}
		}		
		
		return baseInfo;
	}
	
	
	
	private PayordInfo setStatusOrder(PayordInfo baseInfo) {
		boolean hasPaid     = false;
		boolean hasFailed   = false;
		boolean hasCanceled = false;
		
		
		for (PayordemInfo eachPayordem : baseInfo.payordems) {
			String status = getStatusOrder(eachPayordem);
			
			switch(status) {
				case "PAID"    : hasPaid     = true; break;					
				case "FAILED"  : hasFailed   = true; break;
				case "CANCELED": hasCanceled = true; break;
			}
		}
		
		
		if (hasPaid) {
			baseInfo.statusOrderPartner = "PAID";
			return baseInfo;
		}
		
		
		if (hasFailed) {
			baseInfo.statusOrderPartner = "FAILED";
			return baseInfo;
		}
		
		
		if (hasCanceled) {
			baseInfo.statusOrderPartner = "CANCELED";
			return baseInfo;
		}
		
		baseInfo.statusOrderPartner = "PENDING";
		return baseInfo;
	}
	
	
	
	private PayordInfo setStatusPayment(PayordInfo baseInfo) {		
		boolean hasFailed   = false;
		boolean hasCaptured = false;
		
		
		for (PayordemInfo eachPayordem : baseInfo.payordems) {
			String status = getStatusPayment(eachPayordem);
			
			switch(status) {			
				case "FAILED"  : hasFailed   = true; break;
				case "CAPTURED": hasCaptured = true; break;
			}
		}
		
		
		if (hasCaptured) {
			baseInfo.statusPaymentPartner = "CAPTURED";
			return baseInfo;
		}
		
		
		if (hasFailed) {
			baseInfo.statusPaymentPartner = "FAILED";
			return baseInfo;
		}
		
		baseInfo.statusPaymentPartner = "PENDING";
		return baseInfo;
	}
	
	
	
	private String getStatusOrder(PayordemInfo eachPayordem) {
		String status = eachPayordem.statusOrderPartner;
		
		if (status == null)
			status = "null";
		
		return status.toUpperCase();
	}
	
	
	
	private String getStatusPayment(PayordemInfo eachPayordem) {
		String status = eachPayordem.statusPaymentPartner;
		
		if (status == null)
			status = "null";
		
		return status.toUpperCase();
	}
	
	
	
	private String getCode(Map<String,String> eachItem) {
		String payItemCode = eachItem.get("code");
		
		if (payItemCode == null) 
			return "null";
		
		return payItemCode;
	}
	
	
	
	private boolean hasResponseItems(OrdapaInfo selectedInfo) {
		if (selectedInfo.responseItems == null)
			return false;
		
		if (selectedInfo.responseItems.isEmpty())
			return false;
		
		return true;
	}
	
	
	
	@Override public List<PayordInfo> uniquifyHook(List<PayordInfo> results) {
		InfoUniquifier<PayordInfo> uniquifier = new PayordUniquifier();		
		return uniquifier.uniquify(results);
	}
}
