package br.com.mind5.business.employeeRestricted.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class EmplresUniquifier implements InfoUniquifier<EmplresInfo> {
	
	@Override public List<EmplresInfo> uniquify(List<EmplresInfo> infoRecords) {		
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
