package br.com.gda.payService.payPartnerCountry.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PayparCountryUniquifier implements InfoUniquifier<PayparCountryInfo> {
	
	@Override public List<PayparCountryInfo> uniquify(List<PayparCountryInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
