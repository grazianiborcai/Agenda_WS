package br.com.gda.security.userList.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class UselisUniquifier implements InfoUniquifier<UselisInfo> {
	
	@Override public List<UselisInfo> uniquify(List<UselisInfo> infoRecords) {		
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
