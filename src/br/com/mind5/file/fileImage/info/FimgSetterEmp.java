package br.com.mind5.file.fileImage.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class FimgSetterEmp extends InfoSetterTemplate<FimgInfo> {
	
	@Override protected FimgInfo setAttrHook(FimgInfo recordInfo) {
		recordInfo.codOwnerRef = DefaultValue.number();
		recordInfo.codPerson = DefaultValue.number();
		recordInfo.codMat = DefaultValue.number();
		recordInfo.codStore = DefaultValue.number();
		recordInfo.codCustomer = DefaultValue.number();
		recordInfo.codUser = DefaultValue.number();
		
		return recordInfo;
	}
}
