package br.com.mind5.masterData.materialGroupOwner.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatoupowSetterRgbHexHashtag extends InfoSetterTemplate<MatoupowInfo> {
	
	@Override protected MatoupowInfo setAttrHook(MatoupowInfo recordInfo) {
		
		recordInfo.rgbHex = setHashtag(recordInfo.rgbHex);

		return recordInfo;
	}
	
	
	
	private String setHashtag(String rgbHex) {
		if(hasHashtag(rgbHex) == true) 
			return rgbHex;
		
		return "#" + rgbHex;
	}
	
	
	
	private boolean hasHashtag(String rgbHex) {
		return rgbHex.substring(0, 1).equals("#");
	}
}
