package br.com.mind5.file.fileImage.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class FimgSetterCreatedOn extends InfoSetterTemplate<FimgInfo> {
	
	@Override protected FimgInfo setAttrHook(FimgInfo recordInfo) {
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
