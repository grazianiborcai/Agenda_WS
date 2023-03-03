package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;


public final class OrdapaSetterItems extends InfoSetterTemplate<OrdapaInfo> {
	
	@Override protected OrdapaInfo setAttrHook(OrdapaInfo recordInfo) {	
		List<PayordemInfo> payOrdemItems = getPayOrdemItems(recordInfo);
		
		if (payOrdemItems == null)
			return recordInfo;
		
		
		recordInfo.items = getItems(payOrdemItems) ;
		return recordInfo;
	}
	
	
	
	private List<PayordemInfo> getPayOrdemItems(OrdapaInfo recordInfo) {
		if (recordInfo.payordData == null)
			return null;
		
		if (recordInfo.payordData.payordems == null)
			return null;
		
		if (recordInfo.payordData.payordems.isEmpty())
			return null;
		
		return recordInfo.payordData.payordems;
	}
	
	
	
	private List<Map<String,String>> getItems(List<PayordemInfo> payOrdemItems) {
		List<Map<String,String>> items = new ArrayList<>();
		
		
		for (PayordemInfo eachPayordem : payOrdemItems) {
			Map<String, String> eachItem = new HashMap<>();
			
			eachItem = addItemAmount(eachItem, eachPayordem);
			eachItem = addItemDescription(eachItem, eachPayordem);
			eachItem = addItemQuantity(eachItem, eachPayordem);
			eachItem = addItemCode(eachItem, eachPayordem);
			
			items.add(eachItem);			
		}
		
		return items;
	}
	
	
	
	private Map<String,String> addItemAmount(Map<String, String> item, PayordemInfo payordem) {
		String amount = "0";
		double totitem = payordem.totitem * 100;
		
		if (totitem > 0) 
			amount = String.valueOf((int)totitem);
		
		item.put("amount", amount);		
		return item;
	}
	
	
	
	private Map<String,String> addItemDescription(Map<String, String> item, PayordemInfo payordem) {
		if(payordem.matlisData == null)
			return item;
		
		if(payordem.matlisData.txtMat == null)
			return item;
		
		
		item.put("description", payordem.matlisData.txtMat);		
		return item;
	}
	
	
	
	private Map<String,String> addItemQuantity(Map<String, String> item, PayordemInfo payordem) {
		String quantity = "0";
		
		if (payordem.quantity > 0) 
			quantity = String.valueOf(payordem.quantity);
		
		item.put("quantity", quantity);		
		return item;
	}
	
	
	
	private Map<String,String> addItemCode(Map<String, String> item, PayordemInfo payordem) {
		String code = String.valueOf(payordem.codOwner) + "-" +
	                  String.valueOf(payordem.codPayOrder) + "-" +
				      String.valueOf(payordem.codPayOrderItem);
		
		item.put("code", code);		
		return item;
	}
}
