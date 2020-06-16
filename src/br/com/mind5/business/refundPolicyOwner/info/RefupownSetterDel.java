package br.com.mind5.business.refundPolicyOwner.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.RecordMode;

public final class RefupownSetterDel extends InfoSetterTemplate<RefupownInfo> {
	
	@Override protected RefupownInfo setAttrHook(RefupownInfo recordInfo) {	
		recordInfo.recordMode = RecordMode.DELETED.getCodRecordMode();
		return recordInfo;
	}
}
