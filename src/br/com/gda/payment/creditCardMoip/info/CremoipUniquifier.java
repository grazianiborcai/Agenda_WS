package br.com.gda.payment.creditCardMoip.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class CremoipUniquifier implements InfoUniquifier<CremoipInfo> {
	
	@Override public List<CremoipInfo> uniquify(List<CremoipInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
