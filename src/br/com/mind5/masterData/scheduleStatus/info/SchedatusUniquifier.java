package br.com.mind5.masterData.scheduleStatus.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class SchedatusUniquifier implements InfoUniquifier<SchedatusInfo> {
	
	@Override public List<SchedatusInfo> uniquify(List<SchedatusInfo> infoRecords) {		
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
