package br.com.gda.payment.payOrderItem.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PayordemUniquifier implements InfoUniquifier<PayordemInfo> {
	
	@Override public List<PayordemInfo> uniquify(List<PayordemInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
