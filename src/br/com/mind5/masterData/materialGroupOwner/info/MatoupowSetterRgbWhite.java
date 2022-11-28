package br.com.mind5.masterData.materialGroupOwner.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatoupowSetterRgbWhite extends InfoSetterTemplate<MatoupowInfo> {
	
	@Override protected MatoupowInfo setAttrHook(MatoupowInfo recordInfo) {
		recordInfo.rgbHex = "#FFFFFF";
		recordInfo.rgbDecRed = 255;
		recordInfo.rgbDecGreen = 255;
		recordInfo.rgbDecBlue = 255;

		return recordInfo;
	}
}
