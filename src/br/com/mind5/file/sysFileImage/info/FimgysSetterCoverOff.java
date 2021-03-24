package br.com.mind5.file.sysFileImage.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class FimgysSetterCoverOff extends InfoSetterTemplate<FimgysInfo> {
	
	@Override protected FimgysInfo setAttrHook(FimgysInfo recordInfo) {
		recordInfo.isCover = false;		
		return recordInfo;
	}
}
