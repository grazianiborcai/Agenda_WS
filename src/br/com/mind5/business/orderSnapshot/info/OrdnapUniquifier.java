package br.com.mind5.business.orderSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class OrdnapUniquifier implements InfoUniquifier<OrdnapInfo> {
	
	@Override public List<OrdnapInfo> uniquify(List<OrdnapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
