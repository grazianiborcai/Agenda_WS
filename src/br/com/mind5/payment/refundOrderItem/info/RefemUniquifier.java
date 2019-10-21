package br.com.mind5.payment.refundOrderItem.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class RefemUniquifier implements InfoUniquifier<RefemInfo> {
	
	@Override public List<RefemInfo> uniquify(List<RefemInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
