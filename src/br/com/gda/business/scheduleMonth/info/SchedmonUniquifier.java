package br.com.gda.business.scheduleMonth.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class SchedmonUniquifier implements InfoUniquifier<SchedmonInfo> {
	
	@Override public List<SchedmonInfo> uniquify(List<SchedmonInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
