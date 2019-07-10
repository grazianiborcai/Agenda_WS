package br.com.gda.payment.permissionMoip.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PeresmoipUniquifier implements InfoUniquifier<PeresmoipInfo> {
	
	@Override public List<PeresmoipInfo> uniquify(List<PeresmoipInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
