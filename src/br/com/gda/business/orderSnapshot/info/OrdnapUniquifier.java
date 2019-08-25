package br.com.gda.business.orderSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class OrdnapUniquifier implements InfoUniquifier<OrdnapInfo> {
	
	@Override public List<OrdnapInfo> uniquify(List<OrdnapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
