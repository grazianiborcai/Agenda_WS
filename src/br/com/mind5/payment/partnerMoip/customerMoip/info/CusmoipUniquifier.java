package br.com.mind5.payment.partnerMoip.customerMoip.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class CusmoipUniquifier implements InfoUniquifier<CusmoipInfo> {
	
	@Override public List<CusmoipInfo> uniquify(List<CusmoipInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
