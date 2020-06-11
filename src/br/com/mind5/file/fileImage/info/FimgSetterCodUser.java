package br.com.mind5.file.fileImage.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class FimgSetterCodUser extends InfoSetterTemplate<FimgInfo> {
	
	@Override protected FimgInfo setAttrHook(FimgInfo recordInfo) {
		recordInfo.codUser = recordInfo.lastChangedBy;		
		return recordInfo;
	}
}
