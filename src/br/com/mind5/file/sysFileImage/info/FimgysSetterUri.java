package br.com.mind5.file.sysFileImage.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class FimgysSetterUri extends InfoSetterTemplate<FimgysInfo> {
	
	@Override protected FimgysInfo setAttrHook(FimgysInfo recordInfo) {
		recordInfo.fileImgUri = recordInfo.fileImgPath + recordInfo.fileImgName + "." + recordInfo.fileImgExtension;
		return recordInfo;
	}	
}
