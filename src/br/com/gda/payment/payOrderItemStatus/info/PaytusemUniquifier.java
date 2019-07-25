package br.com.gda.payment.payOrderItemStatus.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PaytusemUniquifier implements InfoUniquifier<PaytusemInfo> {
	
	@Override public List<PaytusemInfo> uniquify(List<PaytusemInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
