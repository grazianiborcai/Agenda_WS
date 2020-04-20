package br.com.mind5.security.user.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;

final class UserUniquifier implements InfoUniquifier<UserInfo> {
	
	@Override public List<UserInfo> uniquify(List<UserInfo> infoRecords) {
		List<UserInfo> uniques = new ArrayList<>();		
		
		for (UserInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				UserInfo duple = uniques.get(dupleIndex);
				
				uniquifyAddress(duple, eachRecord);
				uniquifyPhone(duple, eachRecord);
				uniquifyAuthgrole(duple, eachRecord);
				
			} else {
				uniques.add(eachRecord);
			}
		}
			
		
			return uniques;
	}
	
	
	
	private void uniquifyAddress(UserInfo duple, UserInfo eachRecord) {
		List<AddressInfo> allAddresses = new ArrayList<>();
		
		allAddresses.addAll(duple.addresses);
		allAddresses.addAll(eachRecord.addresses);
		
		duple.addresses = allAddresses.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	private void uniquifyPhone(UserInfo duple, UserInfo eachRecord) {
		List<PhoneInfo> allPhones = new ArrayList<>();
		
		allPhones.addAll(duple.phones);
		allPhones.addAll(eachRecord.phones);
		
		duple.phones = allPhones.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	private void uniquifyAuthgrole(UserInfo duple, UserInfo eachRecord) {
		List<AuthgroleInfo> allAuthgroles = new ArrayList<>();
		
		allAuthgroles.addAll(duple.authgroles);
		allAuthgroles.addAll(eachRecord.authgroles);
		
		duple.authgroles = allAuthgroles.stream().distinct().collect(Collectors.toList());
	}
}
