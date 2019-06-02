package br.com.gda.business.orderItem.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class OrderemUniquifier implements InfoUniquifier<OrderemInfo> {
	
	@Override public List<OrderemInfo> uniquify(List<OrderemInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
