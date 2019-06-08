package br.com.gda.business.cartReserve.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class CarterveUniquifier implements InfoUniquifier<CarterveInfo> {
	
	@Override public List<CarterveInfo> uniquify(List<CarterveInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
