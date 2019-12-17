package br.com.mind5.business.materialMovementSearch.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class MatmarchUniquifier implements InfoUniquifier<MatmarchInfo> {
	
	@Override public List<MatmarchInfo> uniquify(List<MatmarchInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
