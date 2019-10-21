package br.com.mind5.business.materialText.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class MatextUniquifier implements InfoUniquifier<MatextInfo> {
	
	@Override public List<MatextInfo> uniquify(List<MatextInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
