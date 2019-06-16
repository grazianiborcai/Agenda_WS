package br.com.gda.payment.customer.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PaycusUniquifier implements InfoUniquifier<PaycusInfo> {
	
	@Override public List<PaycusInfo> uniquify(List<PaycusInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
