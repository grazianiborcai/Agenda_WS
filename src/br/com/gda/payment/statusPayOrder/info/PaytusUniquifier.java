package br.com.gda.payment.statusPayOrder.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.statusPayOrderItem.info.PaytusemInfo;

final class PaytusUniquifier implements InfoUniquifier<PaytusInfo> {
	
	@Override public List<PaytusInfo> uniquify(List<PaytusInfo> infoRecords) {
		List<PaytusInfo> uniques = new ArrayList<>();		
		
		for (PaytusInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				PaytusInfo duple = uniques.get(dupleIndex);
				
				uniquifyPaytusem(duple, eachRecord);
				
			} else {
				uniques.add(eachRecord);
			}
		}
			
		
			return uniques;
	}
	
	
	
	private void uniquifyPaytusem(PaytusInfo duple, PaytusInfo eachRecord) {
		List<PaytusemInfo> allPayordems = new ArrayList<>();
		
		allPayordems.addAll(duple.paytusems);
		allPayordems.addAll(eachRecord.paytusems);
		
		duple.paytusems = allPayordems.stream().distinct().collect(Collectors.toList());
	}
}
