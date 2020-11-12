package br.com.mind5.business.feeOwner.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.feeCategory.info.Feecat;

public final class FeewnerSetterCategServ extends InfoSetterTemplate<FeewnerInfo> {
	
	@Override protected FeewnerInfo setAttrHook(FeewnerInfo recordInfo) {	
		recordInfo.codFeeCateg = Feecat.SERVICE.getCodCateg();
		return recordInfo;
	}
}
