package br.com.mind5.payment.creditCard.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class CrecardUniquifier implements InfoUniquifier<CrecardInfo> {
	
	@Override public List<CrecardInfo> uniquify(List<CrecardInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
