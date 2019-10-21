package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoUniquifier;

final class CusUniquifier implements InfoUniquifier<CusInfo> {
	
	@Override public List<CusInfo> uniquify(List<CusInfo> infoRecords) {
		List<CusInfo> uniques = new ArrayList<>();		
		
		for (CusInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				CusInfo duple = uniques.get(dupleIndex);
				
				uniquifyAddress(duple, eachRecord);
				uniquifyPhone(duple, eachRecord);
				
			} else {
				uniques.add(eachRecord);
			}
		}
			
		
			return uniques;
	}
	
	
	
	private void uniquifyAddress(CusInfo duple, CusInfo eachRecord) {
		List<AddressInfo> allAddresses = new ArrayList<>();
		
		allAddresses.addAll(duple.addresses);
		allAddresses.addAll(eachRecord.addresses);
		
		duple.addresses = allAddresses.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	private void uniquifyPhone(CusInfo duple, CusInfo eachRecord) {
		List<PhoneInfo> allPhones = new ArrayList<>();
		
		allPhones.addAll(duple.phones);
		allPhones.addAll(eachRecord.phones);
		
		duple.phones = allPhones.stream().distinct().collect(Collectors.toList());
	}
}
