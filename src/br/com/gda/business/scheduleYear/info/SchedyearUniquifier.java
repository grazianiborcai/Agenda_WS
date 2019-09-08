package br.com.gda.business.scheduleYear.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class SchedyearUniquifier implements InfoUniquifier<SchedyearInfo> {
	
	@Override public List<SchedyearInfo> uniquify(List<SchedyearInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
