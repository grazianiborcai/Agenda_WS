package br.com.mind5.payment.payOrderSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class PayordarchUniquifier implements InfoUniquifier<PayordarchInfo> {
	
	@Override public List<PayordarchInfo> uniquify(List<PayordarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
