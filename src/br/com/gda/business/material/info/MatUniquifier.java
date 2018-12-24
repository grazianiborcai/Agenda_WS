package br.com.gda.business.material.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class MatUniquifier implements InfoUniquifier<MatInfo> {
	
	@Override public List<MatInfo> uniquify(List<MatInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
