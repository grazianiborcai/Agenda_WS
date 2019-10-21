package br.com.mind5.security.user.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoUniquifier;

final class UserUniquifier implements InfoUniquifier<UserInfo> {
	
	@Override public List<UserInfo> uniquify(List<UserInfo> infoRecords) {
		List<UserInfo> uniques = new ArrayList<>();		
		
		for (UserInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				UserInfo duple = uniques.get(dupleIndex);
				
				uniquifyAddress(duple, eachRecord);
				uniquifyPhone(duple, eachRecord);
				uniquifyAuthGrRole(duple, eachRecord);
				
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
	
	
	
	private void uniquifyAuthGrRole(UserInfo duple, UserInfo eachRecord) {
		List<AuthGrRoleInfo> allAuthGrRoles = new ArrayList<>();
		
		allAuthGrRoles.addAll(duple.authGrRoles);
		allAuthGrRoles.addAll(eachRecord.authGrRoles);
		
		duple.authGrRoles = allAuthGrRoles.stream().distinct().collect(Collectors.toList());
	}
}
