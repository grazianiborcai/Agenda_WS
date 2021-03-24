package br.com.mind5.file.fileImage.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class FimgSetterStore extends InfoSetterTemplate<FimgInfo> {
	
	@Override protected FimgInfo setAttrHook(FimgInfo recordInfo) {
		recordInfo.codOwnerRef = DefaultValue.number();
		recordInfo.codPerson = DefaultValue.number();
		recordInfo.codEmployee = DefaultValue.number();
		recordInfo.codMat = DefaultValue.number();
		recordInfo.codCustomer = DefaultValue.number();
		recordInfo.codUser = DefaultValue.number();
		recordInfo.codGroup = DefaultValue.number();
		
		return recordInfo;
	}
}
