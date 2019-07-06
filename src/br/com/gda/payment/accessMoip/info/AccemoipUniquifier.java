package br.com.gda.payment.accessMoip.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class AccemoipUniquifier implements InfoUniquifier<AccemoipInfo> {
	
	@Override public List<AccemoipInfo> uniquify(List<AccemoipInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
