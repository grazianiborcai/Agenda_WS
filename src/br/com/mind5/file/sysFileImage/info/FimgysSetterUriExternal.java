package br.com.mind5.file.sysFileImage.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class FimgysSetterUriExternal extends InfoSetterTemplate<FimgysInfo> {
	
	@Override protected FimgysInfo setAttrHook(FimgysInfo recordInfo) {
		recordInfo.fileImgUriExternal = recordInfo.fileImgPathExternal + recordInfo.fileImgName + "." + recordInfo.fileImgExtension;
		return recordInfo;
	}
}
