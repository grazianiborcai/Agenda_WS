package br.com.mind5.security.userSnapshot.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;

final class UserapUniquifier implements InfoUniquifier<UserapInfo> {
	
	@Override public List<UserapInfo> uniquify(List<UserapInfo> infoRecords) {
		List<UserapInfo> uniques = new ArrayList<>();		
		
		for (UserapInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				UserapInfo duple = uniques.get(dupleIndex);
				
				uniquifyAddress(duple, eachRecord);
				uniquifyPhone(duple, eachRecord);
				uniquifyAuthgrole(duple, eachRecord);
				
			} else {
				uniques.add(eachRecord);
			}
		}
			
		
			return uniques;
	}
	
	
	
	private void uniquifyAddress(UserapInfo duple, UserapInfo eachRecord) {
		List<AddresnapInfo> allAddresses = new ArrayList<>();
		
		allAddresses.addAll(duple.addresses);
		allAddresses.addAll(eachRecord.addresses);
		
		duple.addresses = allAddresses.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	private void uniquifyPhone(UserapInfo duple, UserapInfo eachRecord) {
		List<PhonapInfo> allPhones = new ArrayList<>();
		
		allPhones.addAll(duple.phones);
		allPhones.addAll(eachRecord.phones);
		
		duple.phones = allPhones.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	private void uniquifyAuthgrole(UserapInfo duple, UserapInfo eachRecord) {
		List<AuthgroleInfo> allAuthgroles = new ArrayList<>();
		
		allAuthgroles.addAll(duple.authgroles);
		allAuthgroles.addAll(eachRecord.authgroles);
		
		duple.authgroles = allAuthgroles.stream().distinct().collect(Collectors.toList());
	}
}
