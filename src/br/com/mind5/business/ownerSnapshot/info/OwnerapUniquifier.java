package br.com.mind5.business.ownerSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class OwnerapUniquifier implements InfoUniquifier<OwnerapInfo> {
	
	@Override public List<OwnerapInfo> uniquify(List<OwnerapInfo> infoRecords) {
			return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
