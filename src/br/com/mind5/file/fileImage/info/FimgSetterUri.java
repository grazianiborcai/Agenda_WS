package br.com.mind5.file.fileImage.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class FimgSetterUri extends InfoSetterTemplate<FimgInfo> {
	
	@Override protected FimgInfo setAttrHook(FimgInfo recordInfo) {
		recordInfo.fileImgUri = recordInfo.fileImgPath + recordInfo.fileImgName + "." + recordInfo.fileImgExtension;
		return recordInfo;
	}	
}
