package br.com.gda.business.orderList.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class OrdistUniquifier implements InfoUniquifier<OrdistInfo> {
	
	@Override public List<OrdistInfo> uniquify(List<OrdistInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
