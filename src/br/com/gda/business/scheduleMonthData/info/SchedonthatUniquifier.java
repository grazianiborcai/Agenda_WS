package br.com.gda.business.scheduleMonthData.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class SchedonthatUniquifier implements InfoUniquifier<SchedonthatInfo> {
	
	@Override public List<SchedonthatInfo> uniquify(List<SchedonthatInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
