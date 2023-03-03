package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.feeCategory.info.Feecat;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;


public final class OrdapaSetterSplit extends InfoSetterTemplate<OrdapaInfo> {
	
	@Override protected OrdapaInfo setAttrHook(OrdapaInfo recordInfo) {	
		List<PayordemInfo> payOrdemItems = getPayOrdemItems(recordInfo);
		
		if (payOrdemItems == null)
			return recordInfo;
		
		recordInfo.split = getSplit(payOrdemItems);		
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
	
	
	
	private Map<Map<String,String>,Map<String,String>> getSplit(List<PayordemInfo> payOrdemItems) {
		Map<String,String> splitData = new HashMap<>();
		Map<String,String> splitOption = new HashMap<>();
		Map<Map<String,String>,Map<String,String>> split = new HashMap<>();
		
		
		for (PayordemInfo eachPayordem : payOrdemItems) {			
			splitData   = getSplitData  (splitData  , eachPayordem);
			splitOption = getSplitOption(splitOption, eachPayordem);
			
			split.put(splitData, splitOption);
		}
		
		
		return split;
	}
	
	
	
	private Map<String,String> getSplitData(Map<String, String> splitData, PayordemInfo payordem) {
		splitData = addSplitDataAmount(splitData, payordem);
		splitData = addSplitDataRecipientId(splitData, payordem);
		splitData = addSplitDataType(splitData, payordem);
		
		return splitData;
	}
	
	
	
	private Map<String,String> getSplitOption(Map<String, String> splitOption, PayordemInfo payordem) {
		splitOption = addSplitOptionProcessingFee(splitOption, payordem);
		splitOption = addSplitOptionRemainderFee(splitOption, payordem);
		splitOption = addSplitOptionLiable(splitOption, payordem);
		
		return splitOption;
	}
	
	
	
	private Map<String,String> addSplitDataAmount(Map<String, String> splitData, PayordemInfo payordem) {
		String amount = "0";
		double totitem = payordem.totitem * 100;
		
		if (totitem > 0) 
			amount = String.valueOf((int)totitem);
		
		splitData.put("amount", amount);		
		return splitData;
	}
	
	
	
	private Map<String,String> addSplitDataRecipientId(Map<String, String> splitData, PayordemInfo payordem) {
		splitData.put("recipient_id", payordem.itemReceiver);		
		return splitData;
	}
	
	
	
	private Map<String,String> addSplitDataType(Map<String, String> splitData, PayordemInfo payordem) {
		splitData.put("type", "flat");		
		return splitData;
	}
	
	
	
	private Map<String,String> addSplitOptionProcessingFee(Map<String, String> splitData, PayordemInfo payordem) {
		String chargeProcessingFee = "true";
		
		if (isServiceFee(payordem) == true)
			chargeProcessingFee = "false";
		
		splitData.put("charge_processing_fee", chargeProcessingFee);		
		return splitData;
	}
	
	
	
	private Map<String,String> addSplitOptionRemainderFee(Map<String, String> splitData, PayordemInfo payordem) {
		String chargeRemainderFee = "true";
		
		if (isServiceFee(payordem) == true)
			chargeRemainderFee = "false";
		
		splitData.put("charge_remainder_fee", chargeRemainderFee);		
		return splitData;
	}
	
	
	
	private Map<String,String> addSplitOptionLiable(Map<String, String> splitData, PayordemInfo payordem) {
		String liable = "true";
		
		if (isServiceFee(payordem) == true)
			liable = "false";
		
		splitData.put("liable", liable);		
		return splitData;
	}
	
	
	
	private boolean isServiceFee(PayordemInfo payordem) {
		if (payordem.codFeeCateg == Feecat.SERVICE.getCodCateg())
			return true;
		
		return false;
	}
}
