package br.com.gda.business.masterData.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class CountryLegalUniquifier implements InfoUniquifier<CountryLegalInfo> {
	
	@Override public List<CountryLegalInfo> uniquify(List<CountryLegalInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
