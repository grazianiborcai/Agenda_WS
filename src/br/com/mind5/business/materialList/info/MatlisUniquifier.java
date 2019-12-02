package br.com.mind5.business.materialList.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class MatlisUniquifier implements InfoUniquifier<MatlisInfo> {
	
	@Override public List<MatlisInfo> uniquify(List<MatlisInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
