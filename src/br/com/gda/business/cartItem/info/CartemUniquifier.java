package br.com.gda.business.cartItem.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class CartemUniquifier implements InfoUniquifier<CartemInfo> {
	
	@Override public List<CartemInfo> uniquify(List<CartemInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
