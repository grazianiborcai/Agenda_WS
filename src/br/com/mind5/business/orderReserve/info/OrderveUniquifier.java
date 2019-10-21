package br.com.mind5.business.orderReserve.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class OrderveUniquifier implements InfoUniquifier<OrderveInfo> {
	
	@Override public List<OrderveInfo> uniquify(List<OrderveInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
