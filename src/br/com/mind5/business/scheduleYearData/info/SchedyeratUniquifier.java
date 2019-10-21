package br.com.mind5.business.scheduleYearData.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class SchedyeratUniquifier implements InfoUniquifier<SchedyeratInfo> {
	
	@Override public List<SchedyeratInfo> uniquify(List<SchedyeratInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
