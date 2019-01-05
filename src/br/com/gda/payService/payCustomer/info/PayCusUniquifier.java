package br.com.gda.payService.payCustomer.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PayCusUniquifier implements InfoUniquifier<PayCusInfo> {
	
	@Override public List<PayCusInfo> uniquify(List<PayCusInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
