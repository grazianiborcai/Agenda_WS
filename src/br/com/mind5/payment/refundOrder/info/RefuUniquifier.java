package br.com.mind5.payment.refundOrder.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class RefuUniquifier implements InfoUniquifier<RefuInfo> {
	
	@Override public List<RefuInfo> uniquify(List<RefuInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
