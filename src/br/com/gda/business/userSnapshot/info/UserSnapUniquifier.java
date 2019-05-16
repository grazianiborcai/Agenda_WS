package br.com.gda.business.userSnapshot.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.info.InfoUniquifier;

final class UserSnapUniquifier implements InfoUniquifier<UserSnapInfo> {
	
	@Override public List<UserSnapInfo> uniquify(List<UserSnapInfo> infoRecords) {
		List<UserSnapInfo> uniques = new ArrayList<>();		
		
		for (UserSnapInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				UserSnapInfo duple = uniques.get(dupleIndex);
				
				uniquifyAddress(duple, eachRecord);
				uniquifyPhone(duple, eachRecord);
				
			} else {
				uniques.add(eachRecord);
			}
		}
			
		
			return uniques;
	}
	
	
	
	private void uniquifyAddress(UserSnapInfo duple, UserSnapInfo eachRecord) {
		List<AddresnapInfo> allAddresses = new ArrayList<>();
		
		allAddresses.addAll(duple.addresses);
		allAddresses.addAll(eachRecord.addresses);
		
		duple.addresses = allAddresses.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	private void uniquifyPhone(UserSnapInfo duple, UserSnapInfo eachRecord) {
		List<PhoneSnapInfo> allPhones = new ArrayList<>();
		
		allPhones.addAll(duple.phones);
		allPhones.addAll(eachRecord.phones);
		
		duple.phones = allPhones.stream().distinct().collect(Collectors.toList());
	}
}
