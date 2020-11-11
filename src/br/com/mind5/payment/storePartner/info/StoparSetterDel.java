package br.com.mind5.payment.storePartner.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.RecordMode;

public final class StoparSetterDel extends InfoSetterTemplate<StoparInfo> {
	
	@Override protected StoparInfo setAttrHook(StoparInfo recordInfo) {
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
}
