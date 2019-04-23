package br.com.gda.business.customerSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class CusarchUniquifier implements InfoUniquifier<CusarchInfo> {
	
	@Override public List<CusarchInfo> uniquify(List<CusarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
