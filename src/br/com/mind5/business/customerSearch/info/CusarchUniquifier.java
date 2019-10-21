package br.com.mind5.business.customerSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class CusarchUniquifier implements InfoUniquifier<CusarchInfo> {
	
	@Override public List<CusarchInfo> uniquify(List<CusarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
