package br.com.gda.webhook.moipRefund.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class WokefumoipUniquifier implements InfoUniquifier<WokefumoipInfo> {
	
	@Override public List<WokefumoipInfo> uniquify(List<WokefumoipInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
