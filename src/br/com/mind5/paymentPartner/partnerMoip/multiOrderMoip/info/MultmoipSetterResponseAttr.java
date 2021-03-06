package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.List;
import java.util.Map;

import br.com.mind5.info.InfoSetterTemplate;

public final class MultmoipSetterResponseAttr extends InfoSetterTemplate<MultmoipInfo> {
	@SuppressWarnings("unchecked")
	@Override protected MultmoipInfo setAttrHook(MultmoipInfo recordInfo) {
		Map<String, Object> amounts = (Map<String, Object>) recordInfo.response.get("amount");	
		Map<String, Object> links = (Map<String, Object>) recordInfo.response.get("_links");		
		Map<String, Object> selfs = (Map<String, Object>) links.get("self");		
		
		recordInfo.idOrderPartner = (String) recordInfo.response.get("id");
		recordInfo.statusOrderPartner = (String) recordInfo.response.get("status");
		recordInfo.amountTotalPartner = String.valueOf(amounts.get("total"));
		recordInfo.amountCurrencyPartner = (String) amounts.get("currency");		
		recordInfo.urlSelf = (String) selfs.get("href");		

		recordInfo = setAttrUrl(links, recordInfo);		
		recordInfo = setAttrPayment(recordInfo);
		return recordInfo;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private MultmoipInfo setAttrUrl(Map<String, Object> links, MultmoipInfo recordInfo) {
		if (checkMap(links) == false)
			return recordInfo;		
		
		
		Map<String, Object> checkout = (Map<String, Object>) links.get("checkout");	
		
		if (checkMap(checkout) == false)
			return recordInfo;
		
		
		Map<String, Object> payCreditCard = (Map<String, Object>) checkout.get("payCreditCard");
		Map<String, Object> payBoleto = (Map<String, Object>) checkout.get("payBoleto");
		
		if (checkMap(payCreditCard))
			recordInfo.urlPayCard = (String) payCreditCard.get("redirectHref");
		
		if (checkMap(payBoleto))
			recordInfo.urlPayBoleto = (String) payBoleto.get("redirectHref");
		
		
		return recordInfo;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private MultmoipInfo setAttrPayment(MultmoipInfo recordInfo) {
		List<Map<String, Object>> multiPayments = (List<Map<String, Object>>) recordInfo.response.get("multiPayment");	
		
		if (checkList(multiPayments) == false)
			return recordInfo;
		
		Map<String, Object> onePayment = multiPayments.get(0);
		
		if (checkMap(onePayment) == false)
			return recordInfo;
		
		recordInfo.idPaymentPartner = (String) onePayment.get("id");
		recordInfo.statusPaymentPartner = (String) onePayment.get("status");
		
		return recordInfo;
	}
	
	
	
	private boolean checkList(List<Map<String, Object>> list) {
		if (list == null)
			return false;
		
		if (list.isEmpty())
			return false;
		
		return true;
	}
	
	
	
	private boolean checkMap(Map<String, Object> map) {
		if (map == null)
			return false;
		
		if (map.isEmpty())
			return false;
		
		return true;
	}
}
