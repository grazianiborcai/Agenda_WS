package br.com.gda.business.order.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class OrderUniquifier implements InfoUniquifier<OrderInfo> {
	
	@Override public List<OrderInfo> uniquify(List<OrderInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
