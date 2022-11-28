package br.com.mind5.masterData.materialGroupOwner.info;

import java.awt.Color;

import br.com.mind5.info.InfoSetterTemplate;

public final class MatoupowSetterRgbDec extends InfoSetterTemplate<MatoupowInfo> {
	
	@Override protected MatoupowInfo setAttrHook(MatoupowInfo recordInfo) {
		Color rgb = Color.decode(recordInfo.rgbHex);
		
		recordInfo.rgbDecRed 	= rgb.getRed();
		recordInfo.rgbDecGreen 	= rgb.getGreen();
		recordInfo.rgbDecBlue 	= rgb.getBlue();

		return recordInfo;
	}
}
