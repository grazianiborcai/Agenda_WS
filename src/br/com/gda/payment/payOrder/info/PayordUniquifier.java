package br.com.gda.payment.payOrder.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

final class PayordUniquifier implements InfoUniquifier<PayordInfo> {
	
	@Override public List<PayordInfo> uniquify(List<PayordInfo> infoRecords) {
		List<PayordInfo> uniques = new ArrayList<>();		
		
		for (PayordInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				PayordInfo duple = uniques.get(dupleIndex);
				
				uniquifyPayordem(duple, eachRecord);
				
			} else {
				uniques.add(eachRecord);
			}
		}
			
		
			return uniques;
	}
	
	
	
	private void uniquifyPayordem(PayordInfo duple, PayordInfo eachRecord) {
		List<PayordemInfo> allPayordems = new ArrayList<>();
		
		allPayordems.addAll(duple.payordems);
		allPayordems.addAll(eachRecord.payordems);
		
		duple.payordems = allPayordems.stream().distinct().collect(Collectors.toList());
	}
}
