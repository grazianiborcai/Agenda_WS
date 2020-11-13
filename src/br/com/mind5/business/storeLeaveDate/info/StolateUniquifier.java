package br.com.mind5.business.storeLeaveDate.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

public final class StolateUniquifier implements InfoUniquifier<StolateInfo> {
	
	@Override public List<StolateInfo> uniquify(List<StolateInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
