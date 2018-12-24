package br.com.gda.business.cartSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class CartSnapUniquifier implements InfoUniquifier<CartSnapInfo> {
	
	@Override public List<CartSnapInfo> uniquify(List<CartSnapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
