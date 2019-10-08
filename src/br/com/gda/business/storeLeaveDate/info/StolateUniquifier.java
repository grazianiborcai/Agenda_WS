package br.com.gda.business.storeLeaveDate.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class StolateUniquifier implements InfoUniquifier<StolateInfo> {
	
	@Override public List<StolateInfo> uniquify(List<StolateInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
