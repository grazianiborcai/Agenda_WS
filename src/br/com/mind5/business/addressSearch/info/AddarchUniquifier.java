package br.com.mind5.business.addressSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class AddarchUniquifier implements InfoUniquifier<AddarchInfo> {
	
	@Override public List<AddarchInfo> uniquify(List<AddarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
