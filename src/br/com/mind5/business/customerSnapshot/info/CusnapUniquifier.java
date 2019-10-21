package br.com.mind5.business.customerSnapshot.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoUniquifier;

final class CusnapUniquifier implements InfoUniquifier<CusnapInfo> {
	
	@Override public List<CusnapInfo> uniquify(List<CusnapInfo> infoRecords) {
		List<CusnapInfo> uniques = new ArrayList<>();		
		
		for (CusnapInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				CusnapInfo duple = uniques.get(dupleIndex);
				
				uniquifyAddress(duple, eachRecord);
				uniquifyPhone(duple, eachRecord);
				
			} else {
				uniques.add(eachRecord);
			}
		}
			
		
			return uniques;
	}
	
	
	
	private void uniquifyAddress(CusnapInfo duple, CusnapInfo eachRecord) {
		List<AddressInfo> allAddresses = new ArrayList<>();
		
		allAddresses.addAll(duple.addresses);
		allAddresses.addAll(eachRecord.addresses);
		
		duple.addresses = allAddresses.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	private void uniquifyPhone(CusnapInfo duple, CusnapInfo eachRecord) {
		List<PhoneInfo> allPhones = new ArrayList<>();
		
		allPhones.addAll(duple.phones);
		allPhones.addAll(eachRecord.phones);
		
		duple.phones = allPhones.stream().distinct().collect(Collectors.toList());
	}
}
