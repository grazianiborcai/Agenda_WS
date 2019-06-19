package br.com.gda.payment.customerPartner.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class CusparUniquifier implements InfoUniquifier<CusparInfo> {
	
	@Override public List<CusparInfo> uniquify(List<CusparInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
