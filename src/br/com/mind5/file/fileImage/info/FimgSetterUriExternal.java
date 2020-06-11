package br.com.mind5.file.fileImage.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class FimgSetterUriExternal extends InfoSetterTemplate<FimgInfo> {
	
	@Override protected FimgInfo setAttrHook(FimgInfo recordInfo) {
		recordInfo.fileImgUriExternal = recordInfo.fileImgPathExternal + recordInfo.fileImgName + "." + recordInfo.fileImgExtension;
		return recordInfo;
	}
}
