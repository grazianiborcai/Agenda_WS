package br.com.mind5.payment.statusPayOrderItem.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class PaytusemUniquifier implements InfoUniquifier<PaytusemInfo> {
	
	@Override public List<PaytusemInfo> uniquify(List<PaytusemInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
