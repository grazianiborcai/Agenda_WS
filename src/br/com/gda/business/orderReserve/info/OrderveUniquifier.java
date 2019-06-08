package br.com.gda.business.orderReserve.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class OrderveUniquifier implements InfoUniquifier<OrderveInfo> {
	
	@Override public List<OrderveInfo> uniquify(List<OrderveInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
