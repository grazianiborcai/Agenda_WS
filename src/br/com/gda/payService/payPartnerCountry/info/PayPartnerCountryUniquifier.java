package br.com.gda.payService.payPartnerCountry.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PayPartnerCountryUniquifier implements InfoUniquifier<PayPartnerCountryInfo> {
	
	@Override public List<PayPartnerCountryInfo> uniquify(List<PayPartnerCountryInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
