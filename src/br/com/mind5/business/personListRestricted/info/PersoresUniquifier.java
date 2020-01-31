package br.com.mind5.business.personListRestricted.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class PersoresUniquifier implements InfoUniquifier<PersoresInfo> {
	
	@Override public List<PersoresInfo> uniquify(List<PersoresInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
