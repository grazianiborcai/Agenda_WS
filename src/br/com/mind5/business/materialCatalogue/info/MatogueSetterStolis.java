package br.com.mind5.business.materialCatalogue.info;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class MatogueSetterStolis extends InfoSetterTemplate<MatogueInfo> {
	
	@Override protected MatogueInfo setAttrHook(MatogueInfo recordInfo) {		
		if ( shouldSkip(recordInfo) == true )
			return recordInfo;
		
		
		recordInfo = obfuscateStolis(recordInfo);			
		return recordInfo;
	}
	
	
	
	private boolean shouldSkip(MatogueInfo recordInfo) {
		if (recordInfo.matores == null)
			return true;
		
		if (recordInfo.matores.isEmpty())
			return true;
		
		return false;
	}
	
	
	
	private MatogueInfo obfuscateStolis(MatogueInfo recordInfo) {
		for (MatoreInfo eachMatore : recordInfo.matores) {
			eachMatore.stolisData = DefaultValue.object();
		}
		
		return recordInfo;
	}
}
