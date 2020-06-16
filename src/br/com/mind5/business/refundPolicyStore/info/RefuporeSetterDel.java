package br.com.mind5.business.refundPolicyStore.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.RecordMode;

public final class RefuporeSetterDel extends InfoSetterTemplate<RefuporeInfo> {
	
	@Override protected RefuporeInfo setAttrHook(RefuporeInfo recordInfo) {	
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
}
