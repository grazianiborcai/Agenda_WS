package br.com.mind5.business.cart.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class CartUniquifier implements InfoUniquifier<CartInfo> {
	
	@Override public List<CartInfo> uniquify(List<CartInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
