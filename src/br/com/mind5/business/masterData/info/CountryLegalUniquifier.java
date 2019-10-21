package br.com.mind5.business.masterData.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class CountryLegalUniquifier implements InfoUniquifier<CountryLegalInfo> {
	
	@Override public List<CountryLegalInfo> uniquify(List<CountryLegalInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
