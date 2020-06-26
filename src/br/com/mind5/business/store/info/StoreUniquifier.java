package br.com.mind5.business.store.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoUniquifier;

final class StoreUniquifier implements InfoUniquifier<StoreInfo> {
	
	@Override public List<StoreInfo> uniquify(List<StoreInfo> infoRecords) {
		List<StoreInfo> uniques = new ArrayList<>();		
		
		for (StoreInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				StoreInfo duple = uniques.get(dupleIndex);
				
				uniquifyPhone(duple, eachRecord);
				
			} else {
				uniques.add(eachRecord);
			}
		}
			
		
			return uniques;
	}
	
	
	
	private void uniquifyPhone(StoreInfo duple, StoreInfo eachRecord) {
		List<PhoneInfo> allPhones = new ArrayList<>();
		
		allPhones.addAll(duple.phones);
		allPhones.addAll(eachRecord.phones);
		
		duple.phones = allPhones.stream().distinct().collect(Collectors.toList());
	}
}
