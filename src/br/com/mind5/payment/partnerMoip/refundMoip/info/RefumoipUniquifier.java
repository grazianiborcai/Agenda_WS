package br.com.mind5.payment.partnerMoip.refundMoip.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class RefumoipUniquifier implements InfoUniquifier<RefumoipInfo> {
	
	@Override public List<RefumoipInfo> uniquify(List<RefumoipInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
