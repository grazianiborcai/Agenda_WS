package br.com.mind5.masterData.materialGroupOwner.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatoupowSetterRgbHex extends InfoSetterTemplate<MatoupowInfo> {
	
	@Override protected MatoupowInfo setAttrHook(MatoupowInfo recordInfo) {
		recordInfo.rgbHex = decToHex(recordInfo.rgbDecRed, recordInfo.rgbDecGreen, recordInfo.rgbDecBlue);

		return recordInfo;
	}
	
	
	
	private String decToHex(int rgbDecRed, int rgbDecGreen, int rgbDecBlue) {
		return String.format("#%02X%02X%02X", rgbDecRed, rgbDecGreen, rgbDecBlue);
	}
}
