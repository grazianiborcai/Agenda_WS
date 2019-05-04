package br.com.gda.business.planingData.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class PlanataUniquifier implements InfoUniquifier<PlanataInfo> {
	
	@Override public List<PlanataInfo> uniquify(List<PlanataInfo> infoRecords) {		
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
