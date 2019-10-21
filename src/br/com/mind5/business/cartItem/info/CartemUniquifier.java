package br.com.mind5.business.cartItem.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class CartemUniquifier implements InfoUniquifier<CartemInfo> {
	
	@Override public List<CartemInfo> uniquify(List<CartemInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
