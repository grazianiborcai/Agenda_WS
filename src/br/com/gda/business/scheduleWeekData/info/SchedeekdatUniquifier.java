package br.com.gda.business.scheduleWeekData.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class SchedeekdatUniquifier implements InfoUniquifier<SchedeekdatInfo> {
	
	@Override public List<SchedeekdatInfo> uniquify(List<SchedeekdatInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
