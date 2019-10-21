package br.com.mind5.business.scheduleMonthData.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class SchedonthatUniquifier implements InfoUniquifier<SchedonthatInfo> {
	
	@Override public List<SchedonthatInfo> uniquify(List<SchedonthatInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
