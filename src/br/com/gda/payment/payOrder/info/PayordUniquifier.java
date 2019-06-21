package br.com.gda.payment.payOrder.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PayordUniquifier implements InfoUniquifier<PayordInfo> {
	
	@Override public List<PayordInfo> uniquify(List<PayordInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
