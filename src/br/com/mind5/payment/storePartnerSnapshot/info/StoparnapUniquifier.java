package br.com.mind5.payment.storePartnerSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class StoparnapUniquifier implements InfoUniquifier<StoparnapInfo> {
	
	@Override public List<StoparnapInfo> uniquify(List<StoparnapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
