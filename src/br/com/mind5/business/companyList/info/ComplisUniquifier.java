package br.com.mind5.business.companyList.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class ComplisUniquifier implements InfoUniquifier<ComplisInfo> {
	
	@Override public List<ComplisInfo> uniquify(List<ComplisInfo> infoRecords) {		
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
