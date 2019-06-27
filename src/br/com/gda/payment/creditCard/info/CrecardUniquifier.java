package br.com.gda.payment.creditCard.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class CrecardUniquifier implements InfoUniquifier<CrecardInfo> {
	
	@Override public List<CrecardInfo> uniquify(List<CrecardInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
