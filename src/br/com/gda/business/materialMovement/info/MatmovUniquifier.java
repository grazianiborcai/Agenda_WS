package br.com.gda.business.materialMovement.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.info.InfoUniquifier;

final class MatmovUniquifier implements InfoUniquifier<MatmovInfo> {
	
	@Override public List<MatmovInfo> uniquify(List<MatmovInfo> infoRecords) {
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
