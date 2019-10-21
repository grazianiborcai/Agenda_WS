package br.com.mind5.business.scheduleWeek.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class SchedeekUniquifier implements InfoUniquifier<SchedeekInfo> {
	
	@Override public List<SchedeekInfo> uniquify(List<SchedeekInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
