package br.com.gda.business.person.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PersonUniquifier implements InfoUniquifier<PersonInfo> {
	
	@Override public List<PersonInfo> uniquify(List<PersonInfo> infoRecords) {		
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
