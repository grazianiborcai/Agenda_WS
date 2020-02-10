package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class PeresmoipUniquifier implements InfoUniquifier<PeresmoipInfo> {
	
	@Override public List<PeresmoipInfo> uniquify(List<PeresmoipInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
