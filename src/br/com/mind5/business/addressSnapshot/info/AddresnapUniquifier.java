package br.com.mind5.business.addressSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class AddresnapUniquifier implements InfoUniquifier<AddresnapInfo> {
	
	@Override public List<AddresnapInfo> uniquify(List<AddresnapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
