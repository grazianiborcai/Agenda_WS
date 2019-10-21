package br.com.mind5.business.cartReserve.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class CarterveUniquifier implements InfoUniquifier<CarterveInfo> {
	
	@Override public List<CarterveInfo> uniquify(List<CarterveInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
