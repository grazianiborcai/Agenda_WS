package br.com.mind5.file.sysFileImage.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class FimgysSetterGroup extends InfoSetterTemplate<FimgysInfo> {
	
	@Override protected FimgysInfo setAttrHook(FimgysInfo recordInfo) {		
		return recordInfo;
	}
}
