package br.com.gda.payment.partnerMoip.multiOrderMoip.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class MultmoipUniquifier implements InfoUniquifier<MultmoipInfo> {
	
	@Override public List<MultmoipInfo> uniquify(List<MultmoipInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
