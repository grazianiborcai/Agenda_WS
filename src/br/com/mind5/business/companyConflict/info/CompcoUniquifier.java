package br.com.mind5.business.companyConflict.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class CompcoUniquifier implements InfoUniquifier<CompcoInfo> {
	
	@Override public List<CompcoInfo> uniquify(List<CompcoInfo> infoRecords) {		
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
