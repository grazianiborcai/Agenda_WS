package br.com.gda.webhook.moipMultipayment.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class WokaymoipUniquifier implements InfoUniquifier<WokaymoipInfo> {
	
	@Override public List<WokaymoipInfo> uniquify(List<WokaymoipInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
