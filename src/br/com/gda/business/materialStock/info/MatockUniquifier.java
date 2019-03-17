package br.com.gda.business.materialStock.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class MatockUniquifier implements InfoUniquifier<MatockInfo> {
	
	@Override public List<MatockInfo> uniquify(List<MatockInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
