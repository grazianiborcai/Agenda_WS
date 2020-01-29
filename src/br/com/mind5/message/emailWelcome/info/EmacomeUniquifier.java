package br.com.mind5.message.emailWelcome.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class EmacomeUniquifier implements InfoUniquifier<EmacomeInfo> {
	
	@Override public List<EmacomeInfo> uniquify(List<EmacomeInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
