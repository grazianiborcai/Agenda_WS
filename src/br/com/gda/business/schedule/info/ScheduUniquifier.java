package br.com.gda.business.schedule.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class ScheduUniquifier implements InfoUniquifier<ScheduInfo> {
	
	@Override public List<ScheduInfo> uniquify(List<ScheduInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
