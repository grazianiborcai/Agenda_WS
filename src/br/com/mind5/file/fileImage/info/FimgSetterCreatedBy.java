package br.com.mind5.file.fileImage.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class FimgSetterCreatedBy extends InfoSetterTemplate<FimgInfo> {
	
	@Override protected FimgInfo setAttrHook(FimgInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
