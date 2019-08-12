package br.com.gda.business.scheduleLine.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class SchedineUniquifier implements InfoUniquifier<SchedineInfo> {
	
	@Override public List<SchedineInfo> uniquify(List<SchedineInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
