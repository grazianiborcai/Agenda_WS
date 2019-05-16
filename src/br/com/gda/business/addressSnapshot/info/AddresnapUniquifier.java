package br.com.gda.business.addressSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class AddresnapUniquifier implements InfoUniquifier<AddresnapInfo> {
	
	@Override public List<AddresnapInfo> uniquify(List<AddresnapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
