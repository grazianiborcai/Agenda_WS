package br.com.gda.business.address.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class AddressUniquifier implements InfoUniquifier<AddressInfo> {
	
	@Override public List<AddressInfo> uniquify(List<AddressInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
