package br.com.mind5.business.feeDefault.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.feeCategory.info.Feecat;

public final class FeedefSetterCategServ extends InfoSetterTemplate<FeedefInfo> {
	
	@Override protected FeedefInfo setAttrHook(FeedefInfo recordInfo) {
		recordInfo.codFeeCateg = Feecat.SERVICE.getCodCateg();
		return recordInfo;
	}
}
