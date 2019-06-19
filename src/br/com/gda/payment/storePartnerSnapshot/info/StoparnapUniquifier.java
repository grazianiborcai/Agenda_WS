package br.com.gda.payment.storePartnerSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class StoparnapUniquifier implements InfoUniquifier<StoparnapInfo> {
	
	@Override public List<StoparnapInfo> uniquify(List<StoparnapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
