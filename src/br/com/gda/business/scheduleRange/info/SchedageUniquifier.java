package br.com.gda.business.scheduleRange.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class SchedageUniquifier implements InfoUniquifier<SchedageInfo> {
	
	@Override public List<SchedageInfo> uniquify(List<SchedageInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
