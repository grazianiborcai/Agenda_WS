package br.com.mind5.business.address.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class AddressUniquifier implements InfoUniquifier<AddressInfo> {
	
	@Override public List<AddressInfo> uniquify(List<AddressInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
