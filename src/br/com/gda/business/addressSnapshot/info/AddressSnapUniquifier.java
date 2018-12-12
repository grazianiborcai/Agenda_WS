package br.com.gda.business.addressSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class AddressSnapUniquifier implements InfoUniquifier<AddressSnapInfo> {
	
	@Override public List<AddressSnapInfo> uniquify(List<AddressSnapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
