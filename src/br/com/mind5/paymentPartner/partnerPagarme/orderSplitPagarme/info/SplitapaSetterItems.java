package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.feeCategory.info.Feecat;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;


public final class SplitapaSetterItems extends InfoSetterTemplate<SplitapaInfo> {
	
	@Override protected SplitapaInfo setAttrHook(SplitapaInfo recordInfo) {	
		List<PayordemInfo> payOrdemItems = getPayOrdemItems(recordInfo);
		
		if (payOrdemItems == null)
			return recordInfo;
		
		
		recordInfo.items = getItems(payOrdemItems) ;
		return recordInfo;
	}
	
	
	
	private List<PayordemInfo> getPayOrdemItems(SplitapaInfo recordInfo) {
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
		item = addItemDescriptionFee(item, payordem);
		item = addItemDescriptionMat(item, payordem);
	
		return item;
	}
	
	
	
	private Map<String,String> addItemDescriptionFee(Map<String, String> item, PayordemInfo payordem) {				
		if(isFee(payordem) == false) return item;		
		
		String description = null;
			
		if(payordem.txtFeeCateg == null) {
			description = getDefaultDescription(payordem);			
		} else {
			description = payordem.txtFeeCateg;	
		}		
		
		item.put("description", description);		
		return item;
	}
	
	
	
	private Map<String,String> addItemDescriptionMat(Map<String, String> item, PayordemInfo payordem) {
		if(isFee(payordem) == true) return item;		
		
		String description = null;
			
		if(payordem.matlisData == null) {
			description = getDefaultDescription(payordem);
			
		} else if(payordem.matlisData.txtMat == null) {
			description = getDefaultDescription(payordem);	
			
		} else {
			description = payordem.matlisData.txtMat;
		}
		
		item.put("description", description);		
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
	
	
	
	private boolean isFee(PayordemInfo payordem) {
		return payordem.codFeeCateg == Feecat.SERVICE.getCodCateg();
	}
	
	
	
	private String getDefaultDescription(PayordemInfo payordem) {
		return payordem.codOwner + "-" + payordem.codPayOrder + "-" + payordem.codPayOrderItem;
	}
}
