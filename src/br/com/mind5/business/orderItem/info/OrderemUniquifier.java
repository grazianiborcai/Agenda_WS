package br.com.mind5.business.orderItem.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class OrderemUniquifier implements InfoUniquifier<OrderemInfo> {
	
	@Override public List<OrderemInfo> uniquify(List<OrderemInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
