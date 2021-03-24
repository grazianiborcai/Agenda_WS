package br.com.mind5.file.sysFileImage.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class FimgysSetterLChanged extends InfoSetterTemplate<FimgysInfo> {
	
	@Override protected FimgysInfo setAttrHook(FimgysInfo recordInfo) {
		recordInfo.lastChanged = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
