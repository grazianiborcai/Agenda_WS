package br.com.gda.business.orderItemSnapshot.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class OrdemrapUniquifier implements InfoUniquifier<OrdemrapInfo> {
	
	@Override public List<OrdemrapInfo> uniquify(List<OrdemrapInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
