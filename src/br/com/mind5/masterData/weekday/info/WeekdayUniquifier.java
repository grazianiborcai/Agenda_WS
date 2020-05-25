package br.com.mind5.masterData.weekday.info;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;

final class WeekdayUniquifier implements InfoUniquifier<WeekdayInfo> {
	
	@Override public List<WeekdayInfo> uniquify(List<WeekdayInfo> infoRecords) {		
		return infoRecords.stream().distinct().collect(Collectors.toList());
	}
}
