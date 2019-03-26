package br.com.gda.business.materialText.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class MatextUniquifier implements InfoUniquifier<MatextInfo> {
	
	@Override public List<MatextInfo> uniquify(List<MatextInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
