package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class TokemoipUniquifier implements InfoUniquifier<TokemoipInfo> {
	
	@Override public List<TokemoipInfo> uniquify(List<TokemoipInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
