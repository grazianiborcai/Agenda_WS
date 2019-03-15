package br.com.gda.business.storeTime_.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.info.InfoUniquifier;

final class StorimeUniquifier implements InfoUniquifier<StorimeInfo> {
	
	@Override public List<StorimeInfo> uniquify(List<StorimeInfo> infoRecords) {
		List<StorimeInfo> uniques = new ArrayList<>();		
		
		for (StorimeInfo eachRecord : infoRecords) {
			if (uniques.contains(eachRecord)) {
				int dupleIndex = uniques.indexOf(eachRecord);
				StorimeInfo duple = uniques.get(dupleIndex);
				
				uniquifyStowotm(duple, eachRecord);
				
			} else {
				uniques.add(eachRecord);
			}
		}
			
		
			return uniques;
	}
	
	
	
	private void uniquifyStowotm(StorimeInfo duple, StorimeInfo eachRecord) {
		List<StowotmInfo> allStowotms = new ArrayList<>();
		
		allStowotms.addAll(duple.stowotms);
		allStowotms.addAll(eachRecord.stowotms);
		
		duple.stowotms = allStowotms.stream().distinct().collect(Collectors.toList());
	}
}
