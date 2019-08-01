package br.com.gda.payment.refundOrder.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class RefuUniquifier implements InfoUniquifier<RefuInfo> {
	
	@Override public List<RefuInfo> uniquify(List<RefuInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
