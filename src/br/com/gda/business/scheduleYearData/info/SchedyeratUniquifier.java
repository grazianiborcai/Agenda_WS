package br.com.gda.business.scheduleYearData.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class SchedyeratUniquifier implements InfoUniquifier<SchedyeratInfo> {
	
	@Override public List<SchedyeratInfo> uniquify(List<SchedyeratInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
