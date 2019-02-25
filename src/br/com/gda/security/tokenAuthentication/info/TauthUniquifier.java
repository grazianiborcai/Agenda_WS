package br.com.gda.security.tokenAuthentication.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.info.InfoUniquifier;

final class TauthUniquifier implements InfoUniquifier<TauthInfo> {
	
	@Override public List<TauthInfo> uniquify(List<TauthInfo> infoRecords) {
		List<TauthInfo> uniques = new ArrayList<>();		
		
		for (TauthInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				TauthInfo duple = uniques.get(dupleIndex);
				
				uniquifyAuthGrRole(duple, eachRecord);
				
			} else {
				uniques.add(eachRecord);
			}
		}
			
		
			return uniques;
	}
	
	
	
	private void uniquifyAuthGrRole(TauthInfo duple, TauthInfo eachRecord) {
		List<AuthGrRoleInfo> allAuthGrRoles = new ArrayList<>();
		
		allAuthGrRoles.addAll(duple.authGrRoles);
		allAuthGrRoles.addAll(eachRecord.authGrRoles);
		
		duple.authGrRoles = allAuthGrRoles.stream().distinct().collect(Collectors.toList());
	}
}
