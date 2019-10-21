package br.com.mind5.message.email.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class EmailUniquifier implements InfoUniquifier<EmailInfo> {
	
	@Override public List<EmailInfo> uniquify(List<EmailInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
