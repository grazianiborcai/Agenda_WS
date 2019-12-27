package br.com.mind5.security.userSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class UserarchUniquifier implements InfoUniquifier<UserarchInfo> {
	
	@Override public List<UserarchInfo> uniquify(List<UserarchInfo> infoRecords) {		
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
