package br.com.mind5.security.username.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.info.InfoUniquifier;

final class UsernameUniquifier implements InfoUniquifier<UsernameInfo> {
	
	@Override public List<UsernameInfo> uniquify(List<UsernameInfo> infoRecords) {
		List<UsernameInfo> uniques = new ArrayList<>();		
		
		for (UsernameInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				UsernameInfo duple = uniques.get(dupleIndex);
				
				uniquifyAuthGrRole(duple, eachRecord);
				
			} else {
				uniques.add(eachRecord);
			}
		}
			
		
			return uniques;
	}
	
	
	
	private void uniquifyAuthGrRole(UsernameInfo duple, UsernameInfo eachRecord) {
		List<AuthGrRoleInfo> allAuthGrRoles = new ArrayList<>();
		
		allAuthGrRoles.addAll(duple.authGrRoles);
		allAuthGrRoles.addAll(eachRecord.authGrRoles);
		
		duple.authGrRoles = allAuthGrRoles.stream().distinct().collect(Collectors.toList());
	}
}
