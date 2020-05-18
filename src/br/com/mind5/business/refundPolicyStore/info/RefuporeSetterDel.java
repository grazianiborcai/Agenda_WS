package br.com.mind5.business.refundPolicyStore.info;

import br.com.mind5.business.masterData.info.common.RecordMode;
import br.com.mind5.info.InfoSetterTemplate;

public final class RefuporeSetterDel extends InfoSetterTemplate<RefuporeInfo> {
	
	@Override protected RefuporeInfo setAttrHook(RefuporeInfo recordInfo) {	
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
}
