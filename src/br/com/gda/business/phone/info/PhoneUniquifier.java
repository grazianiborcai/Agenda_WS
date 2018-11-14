package br.com.gda.business.phone.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PhoneUniquifier implements InfoUniquifier<PhoneInfo> {
	
	@Override public List<PhoneInfo> uniquify(List<PhoneInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
