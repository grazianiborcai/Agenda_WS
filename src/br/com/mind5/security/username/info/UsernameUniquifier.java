package br.com.mind5.security.username.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;

final class UsernameUniquifier implements InfoUniquifier<UsernameInfo> {
	
	@Override public List<UsernameInfo> uniquify(List<UsernameInfo> infoRecords) {
		List<UsernameInfo> uniques = new ArrayList<>();		
		
		for (UsernameInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				UsernameInfo duple = uniques.get(dupleIndex);
				
				uniquifyAuthgrole(duple, eachRecord);
				
			} else {
				uniques.add(eachRecord);
			}
		}
			
		
			return uniques;
	}
	
	
	
	private void uniquifyAuthgrole(UsernameInfo duple, UsernameInfo eachRecord) {
		List<AuthgroleInfo> allAuthgrole = new ArrayList<>();
		
		allAuthgrole.addAll(duple.authgroles);
		allAuthgrole.addAll(eachRecord.authgroles);
		
		duple.authgroles = allAuthgrole.stream().distinct().collect(Collectors.toList());
	}
}
