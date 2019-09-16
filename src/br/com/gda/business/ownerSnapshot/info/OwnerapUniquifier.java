package br.com.gda.business.ownerSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class OwnerapUniquifier implements InfoUniquifier<OwnerapInfo> {
	
	@Override public List<OwnerapInfo> uniquify(List<OwnerapInfo> infoRecords) {
			return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
