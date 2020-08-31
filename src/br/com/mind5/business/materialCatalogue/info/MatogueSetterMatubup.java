package br.com.mind5.business.materialCatalogue.info;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;

public final class MatogueSetterMatubup extends InfoSetterTemplate<MatogueInfo> {
	
	@Override protected MatogueInfo setAttrHook(MatogueInfo recordInfo) {
		if ( shouldSkip(recordInfo) == true )
			return recordInfo;
		
		
		recordInfo.matubupes = getMatubup(recordInfo);
		return recordInfo;
	}
	
	
	
	private boolean shouldSkip(MatogueInfo recordInfo) {
		if (recordInfo.matores == null)
			return true;
		
		if (recordInfo.matores.isEmpty())
			return true;
		
		return false;
	}
	
	
	
	private List<MatubupInfo> getMatubup(MatogueInfo recordInfo) {
		Set<MatubupInfo> results = new HashSet<>();	
		
		for (MatoreInfo eachMatore : recordInfo.matores) {
			if (eachMatore.matlisData != null) {
				MatubupInfo eachResult = new MatubupInfo();
				
				eachResult.codSubgroup = eachMatore.matlisData.codSubgroup;
				eachResult.txtSubgroup = eachMatore.matlisData.txtSubgroup;
				eachResult.codGroup = eachMatore.matlisData.codGroup;
				eachResult.txtGroup = eachMatore.matlisData.txtGroup; 
				eachResult.sortSubgroup = eachMatore.matlisData.sortSubgroup;
				
				results.add(eachResult);
			}
		}
		
		return new ArrayList<>(results);
	}
}
