package br.com.gda.business.scheduleSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class SchedarchUniquifier implements InfoUniquifier<SchedarchInfo> {
	
	@Override public List<SchedarchInfo> uniquify(List<SchedarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
