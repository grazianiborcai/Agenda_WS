package br.com.gda.payService.payPartnerStore.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PayPartnerStoreUniquifier implements InfoUniquifier<PayPartnerStoreInfo> {
	
	@Override public List<PayPartnerStoreInfo> uniquify(List<PayPartnerStoreInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
