package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

final class MultmoipUniquifier implements InfoUniquifier<MultmoipInfo> {
	
	@Override public List<MultmoipInfo> uniquify(List<MultmoipInfo> infoRecords) {
		List<MultmoipInfo> uniques = new ArrayList<>();		
		
		for (MultmoipInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				MultmoipInfo duple = uniques.get(dupleIndex);
				
				uniquifyOrdmoip(duple, eachRecord);
				
			} else {
				uniques.add(eachRecord);
			}
		}
			
		
			return uniques;
	}
	
	
	
	private void uniquifyOrdmoip(MultmoipInfo duple, MultmoipInfo eachRecord) {
		List<OrdmoipInfo> allPayOrdmoips = new ArrayList<>();
		
		allPayOrdmoips.addAll(duple.ordmoips);
		allPayOrdmoips.addAll(eachRecord.ordmoips);
		
		duple.ordmoips = allPayOrdmoips.stream().distinct().collect(Collectors.toList());
	}
}
