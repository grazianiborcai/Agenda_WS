package br.com.mind5.webhook.moipMultipayment.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class WokaymoipUniquifier implements InfoUniquifier<WokaymoipInfo> {
	
	@Override public List<WokaymoipInfo> uniquify(List<WokaymoipInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
