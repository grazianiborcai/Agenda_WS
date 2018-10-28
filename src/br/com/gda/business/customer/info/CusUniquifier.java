package br.com.gda.business.customer.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class CusUniquifier implements InfoUniquifier<CusInfo> {
	
	@Override public List<CusInfo> uniquify(List<CusInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
