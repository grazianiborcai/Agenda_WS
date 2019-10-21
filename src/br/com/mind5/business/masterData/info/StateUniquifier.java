package br.com.mind5.business.masterData.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class StateUniquifier implements InfoUniquifier<StateInfo> {
	
	@Override public List<StateInfo> uniquify(List<StateInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
