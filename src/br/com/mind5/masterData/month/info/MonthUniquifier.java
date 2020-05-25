package br.com.mind5.masterData.month.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class MonthUniquifier implements InfoUniquifier<MonthInfo> {
	
	@Override public List<MonthInfo> uniquify(List<MonthInfo> infoRecords) {		
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
