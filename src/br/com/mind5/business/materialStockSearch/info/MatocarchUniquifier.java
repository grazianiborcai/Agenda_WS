package br.com.mind5.business.materialStockSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class MatocarchUniquifier implements InfoUniquifier<MatocarchInfo> {
	
	@Override public List<MatocarchInfo> uniquify(List<MatocarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
