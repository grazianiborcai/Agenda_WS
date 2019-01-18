package br.com.gda.payService.payPartnerStore.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PayparStoreUniquifier implements InfoUniquifier<PayparStoreInfo> {
	
	@Override public List<PayparStoreInfo> uniquify(List<PayparStoreInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
