package br.com.mind5.business.orderSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class OrdarchUniquifier implements InfoUniquifier<OrdarchInfo> {
	
	@Override public List<OrdarchInfo> uniquify(List<OrdarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
