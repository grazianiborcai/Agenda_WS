package br.com.mind5.file.fileImage.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class FimgSetterCopy extends InfoSetterTemplate<FimgInfo> {
	
	@Override protected FimgInfo setAttrHook(FimgInfo recordInfo) {
		recordInfo.codFileImg = DefaultValue.number();
		
		return recordInfo;
	}
}
