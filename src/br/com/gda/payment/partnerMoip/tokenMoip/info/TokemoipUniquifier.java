package br.com.gda.payment.partnerMoip.tokenMoip.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class TokemoipUniquifier implements InfoUniquifier<TokemoipInfo> {
	
	@Override public List<TokemoipInfo> uniquify(List<TokemoipInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
