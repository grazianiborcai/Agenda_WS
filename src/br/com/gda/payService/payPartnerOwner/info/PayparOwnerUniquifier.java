package br.com.gda.payService.payPartnerOwner.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PayparOwnerUniquifier implements InfoUniquifier<PayparOwnerInfo> {
	
	@Override public List<PayparOwnerInfo> uniquify(List<PayparOwnerInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
