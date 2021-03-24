package br.com.mind5.file.sysFileImage.info;

import java.util.UUID;

import br.com.mind5.info.InfoSetterTemplate;

public final class FimgysSetterFilename extends InfoSetterTemplate<FimgysInfo> {
	
	@Override protected FimgysInfo setAttrHook(FimgysInfo recordInfo) {
		recordInfo.fileImgName = UUID.randomUUID().toString().replace("-", "");
		return recordInfo;
	}
}
