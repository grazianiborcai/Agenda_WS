package br.com.mind5.business.orderItemSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class OrdemarchUniquifier implements InfoUniquifier<OrdemarchInfo> {
	
	@Override public List<OrdemarchInfo> uniquify(List<OrdemarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
