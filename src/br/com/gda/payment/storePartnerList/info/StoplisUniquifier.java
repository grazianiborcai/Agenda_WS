package br.com.gda.payment.storePartnerList.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class StoplisUniquifier implements InfoUniquifier<StoplisInfo> {
	
	@Override public List<StoplisInfo> uniquify(List<StoplisInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
