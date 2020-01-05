package br.com.mind5.business.cartItemSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class CartemarchUniquifier implements InfoUniquifier<CartemarchInfo> {
	
	@Override public List<CartemarchInfo> uniquify(List<CartemarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
