package br.com.mind5.masterData.materialGroupOwner.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatoupowSetterRgbHexUpper extends InfoSetterTemplate<MatoupowInfo> {
	
	@Override protected MatoupowInfo setAttrHook(MatoupowInfo recordInfo) {
		
		recordInfo.rgbHex = recordInfo.rgbHex.toUpperCase();
		return recordInfo;
	}
}
