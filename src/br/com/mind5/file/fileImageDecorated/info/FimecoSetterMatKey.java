package br.com.mind5.file.fileImageDecorated.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class FimecoSetterMatKey extends InfoSetterTemplate<FimecoInfo> {
	
	@Override protected FimecoInfo setAttrHook(FimecoInfo recordInfo) {
		FimecoInfo result = new FimecoInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codMat = recordInfo.codMat;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		
		return result;
	}
}
