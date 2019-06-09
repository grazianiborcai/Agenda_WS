package br.com.gda.message.emailBody.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class EmabodyUniquifier implements InfoUniquifier<EmabodyInfo> {
	
	@Override public List<EmabodyInfo> uniquify(List<EmabodyInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
