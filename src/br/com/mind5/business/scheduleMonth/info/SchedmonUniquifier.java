package br.com.mind5.business.scheduleMonth.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class SchedmonUniquifier implements InfoUniquifier<SchedmonInfo> {
	
	@Override public List<SchedmonInfo> uniquify(List<SchedmonInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
