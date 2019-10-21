package br.com.mind5.business.phoneSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class PhonarchUniquifier implements InfoUniquifier<PhonarchInfo> {
	
	@Override public List<PhonarchInfo> uniquify(List<PhonarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
