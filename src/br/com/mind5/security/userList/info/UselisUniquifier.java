package br.com.mind5.security.userList.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class UselisUniquifier implements InfoUniquifier<UselisInfo> {
	
	@Override public List<UselisInfo> uniquify(List<UselisInfo> infoRecords) {		
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
