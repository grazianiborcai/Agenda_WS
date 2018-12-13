package br.com.gda.business.phoneSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PhoneSnapUniquifier implements InfoUniquifier<PhoneSnapInfo> {
	
	@Override public List<PhoneSnapInfo> uniquify(List<PhoneSnapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
