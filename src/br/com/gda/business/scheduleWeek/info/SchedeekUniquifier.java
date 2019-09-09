package br.com.gda.business.scheduleWeek.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class SchedeekUniquifier implements InfoUniquifier<SchedeekInfo> {
	
	@Override public List<SchedeekInfo> uniquify(List<SchedeekInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
