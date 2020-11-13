package br.com.mind5.business.employeeLeaveDateRange.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

public final class EmplargUniquifier implements InfoUniquifier<EmplargInfo> {

	@Override public List<EmplargInfo> uniquify(List<EmplargInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
