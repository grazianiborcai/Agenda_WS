package br.com.gda.business.userSnapshot.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.info.InfoUniquifier;

final class UserapUniquifier implements InfoUniquifier<UserapInfo> {
	
	@Override public List<UserapInfo> uniquify(List<UserapInfo> infoRecords) {
		List<UserapInfo> uniques = new ArrayList<>();		
		
		for (UserapInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				UserapInfo duple = uniques.get(dupleIndex);
				
				uniquifyAddress(duple, eachRecord);
				uniquifyPhone(duple, eachRecord);
				uniquifyAuthGrRole(duple, eachRecord);
				
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
	
	
	
	private void uniquifyAuthGrRole(UserapInfo duple, UserapInfo eachRecord) {
		List<AuthGrRoleInfo> allAuthGrRoles = new ArrayList<>();
		
		allAuthGrRoles.addAll(duple.authGrRoles);
		allAuthGrRoles.addAll(eachRecord.authGrRoles);
		
		duple.authGrRoles = allAuthGrRoles.stream().distinct().collect(Collectors.toList());
	}
}
