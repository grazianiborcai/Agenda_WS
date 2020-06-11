package br.com.mind5.file.fileImage.info;

import java.util.UUID;

import br.com.mind5.info.InfoSetterTemplate;

public final class FimgSetterFilename extends InfoSetterTemplate<FimgInfo> {
	
	@Override protected FimgInfo setAttrHook(FimgInfo recordInfo) {
		recordInfo.fileImgName = UUID.randomUUID().toString().replace("-", "");
		return recordInfo;
	}
}
