package br.com.mind5.business.scheduleList.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class SchedistUniquifier implements InfoUniquifier<SchedistInfo> {
	
	@Override public List<SchedistInfo> uniquify(List<SchedistInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
