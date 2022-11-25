package br.com.mind5.masterData.materialGroupOwner.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatoupowSetterLockedOn extends InfoSetterTemplate<MatoupowInfo> {
	
	@Override protected MatoupowInfo setAttrHook(MatoupowInfo recordInfo) {
		recordInfo.isLocked = true;		
		return recordInfo;
	}
}
