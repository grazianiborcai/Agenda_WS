package br.com.mind5.payment.countryPartner.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class CounparUniquifier implements InfoUniquifier<CounparInfo> {
	
	@Override public List<CounparInfo> uniquify(List<CounparInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
